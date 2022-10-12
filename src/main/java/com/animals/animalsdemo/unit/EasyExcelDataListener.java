package com.animals.animalsdemo.unit;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EasyExcelDataListener {
//        /**
//         * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
//         */
//        private static final int BATCH_COUNT = 5;
//        private List<Map<Integer, String>> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//
//        @Override
//        public void invoke(Map<Integer, String> data, AnalysisContext context) {
//            System.out.println("解析到一条数据:{}"+JSON.toJSONString(data));
//            .add(data);
//            if (cachedDataList.size() >= BATCH_COUNT) {
//                saveData();
//                cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//            }
//        }
//
//        @Override
//        public void doAfterAllAnalysed(AnalysisContext context) {
//            saveData();
//            System.out.println("所有数据解析完成！");
//        }
//
//        /**
//         * 加上存储数据库
//         */
//        private void saveData() {
//            System.out.println("{}条数据，开始存储数据库！"+cachedDataList.size());
//            System.out.println("存储数据库成功！");
//        }

}
