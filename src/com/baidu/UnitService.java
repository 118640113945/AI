package com.baidu;


/*
 * unit对话服务
 */
public class UnitService {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */

    public static String utterance() {
        // 请求URL
        String talkUrl = "https://aip.baidubce.com/rpc/2.0/solution/v1/unit_utterance";
        try {
            // 请求参数
            String params = "{\"scene_id\":10813169,\"session_id\":\"\",\"query\":\"" + "北京周六下雨吗" + "\"}";
            String accessToken = AuthService.getAuth();//"#####调用鉴权接口获取的token#####";
            String result = HttpUtil.post(talkUrl, accessToken, "application/json", params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UnitService.utterance();
    }

}