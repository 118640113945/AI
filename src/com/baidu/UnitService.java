package com.baidu;


/*
 * unit�Ի�����
 */
public class UnitService {

    /**
     * ��Ҫ��ʾ���������蹤����
     * FileUtil,Base64Util,HttpUtil,GsonUtils���
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * ����
     */

    public static String utterance() {
        // ����URL
        String talkUrl = "https://aip.baidubce.com/rpc/2.0/solution/v1/unit_utterance";
        try {
            // �������
            String params = "{\"scene_id\":10813169,\"session_id\":\"\",\"query\":\"" + "��������������" + "\"}";
            String accessToken = AuthService.getAuth();//"#####���ü�Ȩ�ӿڻ�ȡ��token#####";
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