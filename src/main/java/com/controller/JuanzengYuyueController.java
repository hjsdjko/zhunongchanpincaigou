
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
 * 捐赠记录
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/juanzengYuyue")
public class JuanzengYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(JuanzengYuyueController.class);

    private static final String TABLE_NAME = "juanzengYuyue";

    @Autowired
    private JuanzengYuyueService juanzengYuyueService;


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
    private NewsService newsService;//商品资讯
    @Autowired
    private NongchanpinService nongchanpinService;//商品
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
        CommonUtil.checkMap(params);
        PageUtils page = juanzengYuyueService.queryPage(params);

        //字典表数据转换
        List<JuanzengYuyueView> list =(List<JuanzengYuyueView>)page.getList();
        for(JuanzengYuyueView c:list){
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
        JuanzengYuyueEntity juanzengYuyue = juanzengYuyueService.selectById(id);
        if(juanzengYuyue !=null){
            //entity转view
            JuanzengYuyueView view = new JuanzengYuyueView();
            BeanUtils.copyProperties( juanzengYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(juanzengYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 捐赠项目
            //级联表
            JuanzengEntity juanzeng = juanzengService.selectById(juanzengYuyue.getJuanzengId());
            if(juanzeng != null){
            BeanUtils.copyProperties( juanzeng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJuanzengId(juanzeng.getId());
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
    public R save(@RequestBody JuanzengYuyueEntity juanzengYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,juanzengYuyue:{}",this.getClass().getName(),juanzengYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            juanzengYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        YonghuEntity userId = yonghuService.selectById((Integer) request.getSession().getAttribute("userId"));
        if(userId.getNewMoney() < juanzengYuyue.getJuanzengNewMoney()){
            return R.error("余额不足请充值");
        }
        userId.setNewMoney(userId.getNewMoney()- juanzengYuyue.getJuanzengNewMoney());
        yonghuService.updateById(userId);
        JuanzengEntity juanzengEntity = juanzengService.selectById(juanzengYuyue.getJuanzengId());
        juanzengEntity.setJuanzengNewMoney(juanzengEntity.getJuanzengNewMoney() + juanzengYuyue.getJuanzengNewMoney());
        juanzengService.updateById(juanzengEntity);
        juanzengYuyue.setInsertTime(new Date());
            juanzengYuyue.setCreateTime(new Date());
            juanzengYuyueService.insert(juanzengYuyue);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JuanzengYuyueEntity juanzengYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,juanzengYuyue:{}",this.getClass().getName(),juanzengYuyue.toString());
        JuanzengYuyueEntity oldJuanzengYuyueEntity = juanzengYuyueService.selectById(juanzengYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            juanzengYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            juanzengYuyueService.updateById(juanzengYuyue);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JuanzengYuyueEntity> oldJuanzengYuyueList =juanzengYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        juanzengYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<JuanzengYuyueEntity> juanzengYuyueList = new ArrayList<>();//上传的东西
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
                            JuanzengYuyueEntity juanzengYuyueEntity = new JuanzengYuyueEntity();
//                            juanzengYuyueEntity.setJuanzengId(Integer.valueOf(data.get(0)));   //捐赠项目 要改的
//                            juanzengYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            juanzengYuyueEntity.setJuanzengNewMoney(data.get(0));                    //捐赠金额 要改的
//                            juanzengYuyueEntity.setInsertTime(date);//时间
//                            juanzengYuyueEntity.setCreateTime(date);//时间
                            juanzengYuyueList.add(juanzengYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        juanzengYuyueService.insertBatch(juanzengYuyueList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = juanzengYuyueService.queryPage(params);

        //字典表数据转换
        List<JuanzengYuyueView> list =(List<JuanzengYuyueView>)page.getList();
        for(JuanzengYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JuanzengYuyueEntity juanzengYuyue = juanzengYuyueService.selectById(id);
            if(juanzengYuyue !=null){


                //entity转view
                JuanzengYuyueView view = new JuanzengYuyueView();
                BeanUtils.copyProperties( juanzengYuyue , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(juanzengYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    JuanzengEntity juanzeng = juanzengService.selectById(juanzengYuyue.getJuanzengId());
                if(juanzeng != null){
                    BeanUtils.copyProperties( juanzeng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJuanzengId(juanzeng.getId());
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
    public R add(@RequestBody JuanzengYuyueEntity juanzengYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,juanzengYuyue:{}",this.getClass().getName(),juanzengYuyue.toString());
        Wrapper<JuanzengYuyueEntity> queryWrapper = new EntityWrapper<JuanzengYuyueEntity>()
            .eq("juanzeng_id", juanzengYuyue.getJuanzengId())
            .eq("yonghu_id", juanzengYuyue.getYonghuId())
//            .notIn("juanzeng_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuanzengYuyueEntity juanzengYuyueEntity = juanzengYuyueService.selectOne(queryWrapper);
        if(juanzengYuyueEntity==null){
            juanzengYuyue.setInsertTime(new Date());
            juanzengYuyue.setCreateTime(new Date());
        juanzengYuyueService.insert(juanzengYuyue);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

