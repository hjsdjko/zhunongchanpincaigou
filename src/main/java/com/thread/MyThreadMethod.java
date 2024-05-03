package com.thread;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.NongchanpinEntity;
import com.entity.NongchanpinOrderEntity;
import com.entity.view.NongchanpinOrderView;
import com.service.NongchanpinOrderService;
import com.service.NongchanpinService;
import com.utils.CommonUtil;
import com.utils.PageUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 线程执行方法（做一些项目启动后 一直要执行的操作，比如根据时间自动更改订单状态，比如订单签收30天自动收货功能，比如根据时间来更改状态）
 */
public class MyThreadMethod extends Thread  {
    private NongchanpinService nongchanpinService;
    private NongchanpinOrderService nongchanpinOrderService;
    public void run() {
        while (!this.isInterrupted()) {// 线程未中断执行循环
            try {
                Thread.sleep(5000); //每隔2000ms执行一次

                /**
                 * 执行订单由已拼单改为已拼单完成   开始
                 */
                List<NongchanpinOrderEntity> yipindanOrders = nongchanpinOrderService.selectList(
                        new EntityWrapper<NongchanpinOrderEntity>()
                                .eq("nongchanpin_order_types", 101)
                                .eq("nongchanpin_order_payment_types", 3)
                );

                if(yipindanOrders.size()>0){
                    List<Integer> nongchanpinIds = new ArrayList<>();//要查询的商品id
                    Map<Integer, List<NongchanpinOrderEntity>> nongchanpinOrderEntityHashMap = new HashMap<>();
                    for(NongchanpinOrderEntity nongchanpinOrder:yipindanOrders){//循环所有已拼单的订单
                        if(!nongchanpinIds.contains(nongchanpinOrder.getNongchanpinId())){
                            nongchanpinIds.add(nongchanpinOrder.getNongchanpinId());
                        }
                        if(nongchanpinOrderEntityHashMap.containsKey(nongchanpinOrder.getNongchanpinId())){//之前存的有
                            List<NongchanpinOrderEntity> orderEntityList = nongchanpinOrderEntityHashMap.get(nongchanpinOrder.getNongchanpinId());
                            orderEntityList.add(nongchanpinOrder);
                        }else{//存的没有
                            List<NongchanpinOrderEntity> orderEntityList =new ArrayList<>();
                            orderEntityList.add(nongchanpinOrder);
                            nongchanpinOrderEntityHashMap.put(nongchanpinOrder.getNongchanpinId(),orderEntityList);
                        }
                    }

                    List<NongchanpinEntity> nongchanpinEntityList = nongchanpinService.selectBatchIds(nongchanpinIds);

                    ArrayList<NongchanpinOrderEntity> yaoxiugaidingdan = new ArrayList<>();//要修改订单
                    for(NongchanpinEntity s:nongchanpinEntityList){
                        List<NongchanpinOrderEntity> orderEntityList = nongchanpinOrderEntityHashMap.get(s.getId());
                        if(orderEntityList.size()==s.getNongchanpinPintuan()){//已拼单人数等于限制人数
                            for(NongchanpinOrderEntity o:orderEntityList){
                                o.setNongchanpinOrderTypes(106);//拼单成功
                                yaoxiugaidingdan.add(o);
                            }
                        }
                        if(orderEntityList.size()>s.getNongchanpinPintuan()){//已拼单人数大于限制人数
                            List<NongchanpinOrderEntity> orderEntityList1 = orderEntityList.subList(0, s.getNongchanpinPintuan());//截取到限制人数的订单
                            for(NongchanpinOrderEntity o:orderEntityList1){
                                o.setNongchanpinOrderTypes(106);//拼单成功
                                yaoxiugaidingdan.add(o);
                            }
                        }
                    }
                    if(yaoxiugaidingdan.size()>0){
                        nongchanpinOrderService.updateBatchById(yaoxiugaidingdan);//修改订单状态为已拼单成功
                    }
                }

                /**
                 * 执行订单由已拼单改为已拼单完成   结束
                 * 查询超时未拼成的订单,把状态改为拼单失败 开始
                 */
                Map<String, Object> params = new HashMap<>();
                params.put("limit","10000");
                params.put("jiezhiTimeEnd",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                params.put("nongchanpinOrderTypes",101);//状态为已拼单
                params.put("nongchanpin_order_payment_types",3);//状态为已拼单
                CommonUtil.checkMap(params);
                PageUtils pageUtils = nongchanpinOrderService.queryPage(params);
                List<NongchanpinOrderView> list =(List<NongchanpinOrderView>)pageUtils.getList();
                if(list.size()>0){
                    ArrayList<NongchanpinOrderEntity> genggaiList = new ArrayList<>();
                    for(NongchanpinOrderView s:list){
                        NongchanpinOrderEntity orderEntity = new NongchanpinOrderEntity();
                        orderEntity.setNongchanpinOrderTypes(107);
                        orderEntity.setId(s.getId());
                        genggaiList.add(orderEntity);
                    }
                    nongchanpinOrderService.updateBatchById(genggaiList);
                }
                /**
                 * 查询超时未拼成的订单,把状态改为拼单失败 结束
                 */

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//			 ------------------ 开始执行 ---------------------------
//            System.out.println("线程执行中:" + System.currentTimeMillis());
        }
    }

    public NongchanpinService getNongchanpinService() {
        return nongchanpinService;
    }

    public void setNongchanpinService(NongchanpinService nongchanpinService) {
        this.nongchanpinService = nongchanpinService;
    }

    public NongchanpinOrderService getNongchanpinOrderService() {
        return nongchanpinOrderService;
    }

    public void setNongchanpinOrderService(NongchanpinOrderService nongchanpinOrderService) {
        this.nongchanpinOrderService = nongchanpinOrderService;
    }
}
