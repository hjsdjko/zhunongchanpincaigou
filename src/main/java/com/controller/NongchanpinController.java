
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongchanpin")
public class NongchanpinController {
    private static final Logger logger = LoggerFactory.getLogger(NongchanpinController.class);

    private static final String TABLE_NAME = "nongchanpin";

    @Autowired
    private NongchanpinService nongchanpinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private CartService cartService;//购物车
    @Autowired
    private ChatService chatService;//客服聊天
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JuanzengService juanzengService;//捐赠项目
    @Autowired
    private JuanzengYuyueService juanzengYuyueService;//捐赠记录
    @Autowired
    private NewsService newsService;//商品资讯
    @Autowired
    private NongchanpinCollectionService nongchanpinCollectionService;//商品收藏
    @Autowired
    private NongchanpinCommentbackService nongchanpinCommentbackService;//商品评价
    @Autowired
    private NongchanpinOrderService nongchanpinOrderService;//商品订单
    @Autowired
    private ShangjiaService shangjiaService;//商家
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        params.put("nongchanpinDeleteStart",1);params.put("nongchanpinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinService.queryPage(params);

        //字典表数据转换
        List<NongchanpinView> list =(List<NongchanpinView>)page.getList();
        for(NongchanpinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinEntity nongchanpin = nongchanpinService.selectById(id);
        if(nongchanpin !=null){
            //entity转view
            NongchanpinView view = new NongchanpinView();
            BeanUtils.copyProperties( nongchanpin , view );//把实体数据重构到view中
            //级联表 商家
            //级联表
            ShangjiaEntity shangjia = shangjiaService.selectById(nongchanpin.getShangjiaId());
            if(shangjia != null){
            BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "shangjiaId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangjiaId(shangjia.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongchanpin:{}",this.getClass().getName(),nongchanpin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("商家".equals(role))
            nongchanpin.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<NongchanpinEntity> queryWrapper = new EntityWrapper<NongchanpinEntity>()
            .eq("shangjia_id", nongchanpin.getShangjiaId())
            .eq("nongchanpin_name", nongchanpin.getNongchanpinName())
            .eq("nongchanpin_types", nongchanpin.getNongchanpinTypes())
            .eq("nongchanpin_kucun_number", nongchanpin.getNongchanpinKucunNumber())
            .eq("nongchanpin_price", nongchanpin.getNongchanpinPrice())
            .eq("nongchanpin_pintuan", nongchanpin.getNongchanpinPintuan())
            .eq("zan_number", nongchanpin.getZanNumber())
            .eq("cai_number", nongchanpin.getCaiNumber())
            .eq("shangxia_types", nongchanpin.getShangxiaTypes())
            .eq("nongchanpin_delete", nongchanpin.getNongchanpinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchanpinEntity nongchanpinEntity = nongchanpinService.selectOne(queryWrapper);
        if(nongchanpinEntity==null){
            nongchanpin.setNongchanpinClicknum(1);
            nongchanpin.setShangxiaTypes(1);
            nongchanpin.setNongchanpinDelete(1);
            nongchanpin.setInsertTime(new Date());
            nongchanpin.setCreateTime(new Date());
            nongchanpinService.insert(nongchanpin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongchanpin:{}",this.getClass().getName(),nongchanpin.toString());
        NongchanpinEntity oldNongchanpinEntity = nongchanpinService.selectById(nongchanpin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("商家".equals(role))
//            nongchanpin.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(nongchanpin.getNongchanpinPhoto()) || "null".equals(nongchanpin.getNongchanpinPhoto())){
                nongchanpin.setNongchanpinPhoto(null);
        }

            nongchanpinService.updateById(nongchanpin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongchanpinEntity> oldNongchanpinList =nongchanpinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<NongchanpinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            NongchanpinEntity nongchanpinEntity = new NongchanpinEntity();
            nongchanpinEntity.setId(id);
            nongchanpinEntity.setNongchanpinDelete(2);
            list.add(nongchanpinEntity);
        }
        if(list != null && list.size() >0){
            nongchanpinService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<NongchanpinEntity> nongchanpinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            NongchanpinEntity nongchanpinEntity = new NongchanpinEntity();
//                            nongchanpinEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            nongchanpinEntity.setNongchanpinName(data.get(0));                    //商品名称 要改的
//                            nongchanpinEntity.setNongchanpinUuidNumber(data.get(0));                    //商品编号 要改的
//                            nongchanpinEntity.setNongchanpinPhoto("");//详情和图片
//                            nongchanpinEntity.setNongchanpinTypes(Integer.valueOf(data.get(0)));   //商品类型 要改的
//                            nongchanpinEntity.setNongchanpinKucunNumber(Integer.valueOf(data.get(0)));   //商品库存 要改的
//                            nongchanpinEntity.setNongchanpinOldMoney(data.get(0));                    //商品原价 要改的
//                            nongchanpinEntity.setNongchanpinNewMoney(data.get(0));                    //现价 要改的
//                            nongchanpinEntity.setNongchanpinPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            nongchanpinEntity.setNongchanpinPintuan(Integer.valueOf(data.get(0)));   //拼团限制/人 要改的
//                            nongchanpinEntity.setNongchanpinClicknum(Integer.valueOf(data.get(0)));   //商品热度 要改的
//                            nongchanpinEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            nongchanpinEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            nongchanpinEntity.setNongchanpinContent("");//详情和图片
//                            nongchanpinEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            nongchanpinEntity.setNongchanpinDelete(1);//逻辑删除字段
//                            nongchanpinEntity.setInsertTime(date);//时间
//                            nongchanpinEntity.setCreateTime(date);//时间
                            nongchanpinList.add(nongchanpinEntity);


                            //把要查询是否重复的字段放入map中
                                //商品编号
                                if(seachFields.containsKey("nongchanpinUuidNumber")){
                                    List<String> nongchanpinUuidNumber = seachFields.get("nongchanpinUuidNumber");
                                    nongchanpinUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongchanpinUuidNumber = new ArrayList<>();
                                    nongchanpinUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongchanpinUuidNumber",nongchanpinUuidNumber);
                                }
                        }

                        //查询是否重复
                         //商品编号
                        List<NongchanpinEntity> nongchanpinEntities_nongchanpinUuidNumber = nongchanpinService.selectList(new EntityWrapper<NongchanpinEntity>().in("nongchanpin_uuid_number", seachFields.get("nongchanpinUuidNumber")).eq("nongchanpin_delete", 1));
                        if(nongchanpinEntities_nongchanpinUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongchanpinEntity s:nongchanpinEntities_nongchanpinUuidNumber){
                                repeatFields.add(s.getNongchanpinUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [商品编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongchanpinService.insertBatch(nongchanpinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<NongchanpinView> returnNongchanpinViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = nongchanpinOrderService.queryPage(params1);
        List<NongchanpinOrderView> orderViewsList =(List<NongchanpinOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(NongchanpinOrderView orderView:orderViewsList){
            Integer nongchanpinTypes = orderView.getNongchanpinTypes();
            if(typeMap.containsKey(nongchanpinTypes)){
                typeMap.put(nongchanpinTypes,typeMap.get(nongchanpinTypes)+1);
            }else{
                typeMap.put(nongchanpinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("nongchanpinTypes",type);
            PageUtils pageUtils1 = nongchanpinService.queryPage(params2);
            List<NongchanpinView> nongchanpinViewList =(List<NongchanpinView>)pageUtils1.getList();
            returnNongchanpinViewList.addAll(nongchanpinViewList);
            if(returnNongchanpinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = nongchanpinService.queryPage(params);
        if(returnNongchanpinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnNongchanpinViewList.size();//要添加的数量
            List<NongchanpinView> nongchanpinViewList =(List<NongchanpinView>)page.getList();
            for(NongchanpinView nongchanpinView:nongchanpinViewList){
                Boolean addFlag = true;
                for(NongchanpinView returnNongchanpinView:returnNongchanpinViewList){
                    if(returnNongchanpinView.getId().intValue() ==nongchanpinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnNongchanpinViewList.add(nongchanpinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnNongchanpinViewList = returnNongchanpinViewList.subList(0, limit);
        }

        for(NongchanpinView c:returnNongchanpinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnNongchanpinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinService.queryPage(params);

        //字典表数据转换
        List<NongchanpinView> list =(List<NongchanpinView>)page.getList();
        for(NongchanpinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinEntity nongchanpin = nongchanpinService.selectById(id);
            if(nongchanpin !=null){

                //点击数量加1
                nongchanpin.setNongchanpinClicknum(nongchanpin.getNongchanpinClicknum()+1);
                nongchanpinService.updateById(nongchanpin);

                //entity转view
                NongchanpinView view = new NongchanpinView();
                BeanUtils.copyProperties( nongchanpin , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(nongchanpin.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody NongchanpinEntity nongchanpin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongchanpin:{}",this.getClass().getName(),nongchanpin.toString());
        Wrapper<NongchanpinEntity> queryWrapper = new EntityWrapper<NongchanpinEntity>()
            .eq("shangjia_id", nongchanpin.getShangjiaId())
            .eq("nongchanpin_name", nongchanpin.getNongchanpinName())
            .eq("nongchanpin_uuid_number", nongchanpin.getNongchanpinUuidNumber())
            .eq("nongchanpin_types", nongchanpin.getNongchanpinTypes())
            .eq("nongchanpin_kucun_number", nongchanpin.getNongchanpinKucunNumber())
            .eq("nongchanpin_price", nongchanpin.getNongchanpinPrice())
            .eq("nongchanpin_pintuan", nongchanpin.getNongchanpinPintuan())
            .eq("nongchanpin_clicknum", nongchanpin.getNongchanpinClicknum())
            .eq("zan_number", nongchanpin.getZanNumber())
            .eq("cai_number", nongchanpin.getCaiNumber())
            .eq("shangxia_types", nongchanpin.getShangxiaTypes())
            .eq("nongchanpin_delete", nongchanpin.getNongchanpinDelete())
//            .notIn("nongchanpin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchanpinEntity nongchanpinEntity = nongchanpinService.selectOne(queryWrapper);
        if(nongchanpinEntity==null){
            nongchanpin.setNongchanpinDelete(1);
            nongchanpin.setInsertTime(new Date());
            nongchanpin.setCreateTime(new Date());
        nongchanpinService.insert(nongchanpin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

