package com.mizuki.sinatv.test;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class TopNews implements Serializable {
    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"01f3ac363127f487c6a7612a0f1e5039","title":"记者走访印度医院 6天60名儿童死亡医院仍在运营 ","date":"2017-08-15 09:45","category":"头条","author_name":"东方IC","url":"http://mini.eastday.com/mobile/170815094524277.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_2_mwpm_03200403.jpg"},{"uniquekey":"a43c21c76980ba2e0d4413afbb3738b3","title":"\u201c科学\u201d号卡罗琳海山发现\u201c永恒爱情\u201d海绵","date":"2017-08-15 09:57","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170815095755223.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815095755_1a6e03fb91f57aadde47c10c2391c5f1_1_mwpm_03200403.jpg"},{"uniquekey":"27571de96ed5892379aeb847faf828ad","title":"\u201c台杂\u201d还是\u201c日杂�？\u201c台湾民政府\u201d成员在靖国神社参拜入口处兴高采烈拍照","date":"2017-08-15 09:55","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815095528354.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815095528_1e5c1a3fa3fe84d57c5eafc6775316ef_1_mwpm_03200403.jpg"},{"uniquekey":"4a7fb83753b2ee8df0d37c96c7849745","title":"文在寅喊话美国：未经韩同意不得动武 朝核问题必须和平解决","date":"2017-08-15 09:55","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815095527993.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815095527_72d4b7bf254122bf6eb01ea42b706e34_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815095527_72d4b7bf254122bf6eb01ea42b706e34_2_mwpm_03200403.jpg"},{"uniquekey":"1831101a90198c963edf25b1a0bd4a28","title":"山西和顺一煤矿矿难 至少4人死亡5人失踪","date":"2017-08-15 09:34","category":"头条","author_name":"中国之声","url":"http://mini.eastday.com/mobile/170815093433536.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815093433_0dd215abdedb84559f87415a2442ec11_1_mwpm_03200403.jpg"},{"uniquekey":"7d8c58946ddfb200d3b5a40c82cb8b22","title":"日本6在野党派战败日发声明：表明反省才是对战亡者的悼念","date":"2017-08-15 09:26","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/170815092640107.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815092640_64e46c111f1a22c27a3a9f32e7273d8c_1_mwpm_03200403.jpg"},{"uniquekey":"09cdc028e73b3f792dedf9d333659ac1","title":"塞拉利昂首都泥石流致死人数已上升至逾300人","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092514546.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170815/20170815092514_1017d9e5b237db3b5ddb6f3c887559d6_1_mwpm_03200403.jpg"},{"uniquekey":"d5ab2477b427aac4879a60aca3c1dac5","title":"布基纳法索遭遇疑似恐袭 法总统力挺布国反恐","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092514490.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815092514_dc1e562623b800e242a4a783d344d93e_1_mwpm_03200403.jpg"},{"uniquekey":"65395bf9ae1c27cc4c9a94bcf35f3389","title":"蒂勒森发表声明庆祝韩国光复72周年 寄语两国关系发展","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092513492.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815092513_9de43d46173956b0967cbbde3eceb1c5_1_mwpm_03200403.jpg"},{"uniquekey":"2da2a647be12781f433b1959ff33f501","title":"疑有自杀倾向男子驾车冲撞餐馆致1死多伤，法国检方排除恐袭","date":"2017-08-15 09:18","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170815091825211.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170815/20170815091825_213d06ab5555381fa2ea4187597d6e98_1_mwpm_03200403.jpg"},{"uniquekey":"6c71ad447ed4738f4c42e85bd42762f8","title":"安倍在山口县老家视察机动车加氢站 意在落实政府举措","date":"2017-08-15 09:15","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815091509335.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815091509_8becec55818ddc0ae40c0d7c08ea3b73_1_mwpm_03200403.jpg"},{"uniquekey":"819b71dbfec36fc1cd7686dc7848f14b","title":"日初中因采用涉慰安妇教材遭抗议 韩教授致信表感谢","date":"2017-08-15 09:15","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815091508516.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815091508_25c82d8133c12944da1134c17ca83ba1_1_mwpm_03200403.jpg"},{"uniquekey":"a48c5dba1f8b28dabe4b2aa10e67f11c","title":"8月份底财神眷顾，八方来财，富甲一方的3大生肖属相！","date":"2017-08-15 09:07","category":"头条","author_name":"吉名轩八字星座","url":"http://mini.eastday.com/mobile/170815090742894.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815_5ea833f6a284e6701dce293000428816_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815_6ecc964571dd3eb63896dbb0f2c67b46_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815_adc6d27a2e8899897cac069464ca7302_cover_mwpm_03200403.jpeg"},{"uniquekey":"4157bf2167ac0188daa915a0f8bc239f","title":"又逢\u201c8·15\u201d 重温72年前抗战胜利的喜悦","date":"2017-08-15 09:05","category":"头条","author_name":"中国军网","url":"http://mini.eastday.com/mobile/170815090501683.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_16_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_15_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_10_mwpm_03200403.jpg"},{"uniquekey":"211075240e5101c94beb56a78f452364","title":"韩美防长拟提前举行首次会晤 谈修改导弹指南等","date":"2017-08-15 09:05","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815090501103.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170815/20170815090501_dd4f3a04e584d22380250ab8c1d890d3_1_mwpm_03200403.jpg"},{"uniquekey":"ba26dce70bfb97ac3560cb11ecf40180","title":"呼吁和平！印巴歌手异地合唱　混合版\u201c国歌\u201d网上爆红","date":"2017-08-15 09:05","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815090500940.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815090500_53c91a6e24c3e865bcc02830593f1701_1_mwpm_03200403.jpg"},{"uniquekey":"9868e9c7d45b1aa80515acdcebe81ec1","title":"日本这家电视台播了一部震惊全日本的节目，在网上遭疯狂围攻！","date":"2017-08-15 09:04","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/170815090459039.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_12_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_13_mwpm_03200403.jpg"},{"uniquekey":"d78a7666f2695acee55c3443295faece","title":"气温计爆表 边防女兵抗50℃高温站军姿","date":"2017-08-15 09:04","category":"头条","author_name":"视觉中国","url":"http://mini.eastday.com/mobile/170815090458906.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_1_mwpm_03200403.jpg"},{"uniquekey":"fdb1b9bcfd75c598abe2d7b32ed85403","title":"19岁怀爷爷的种！一家四口全是禽兽，侵犯姐妹花长达5年","date":"2017-08-15 09:04","category":"头条","author_name":"买菜的老王","url":"http://mini.eastday.com/mobile/170815090416330.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170815/20170815_fc2d0886f5461035c0cd3ef471759e73_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170815/20170815_b0b91b21a3c2c5950202c18454f18d6c_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170815/20170815_76b0efdca02e2c5ff7eaf1c80aa786fc_cover_mwpm_03200403.jpeg"},{"uniquekey":"981d16cf65da2a6c23a4efec2d3c710e","title":"儿媳照顾公公同住一屋子，生活场景曝光后，网友怒赞","date":"2017-08-15 08:49","category":"头条","author_name":"图看世界","url":"http://mini.eastday.com/mobile/170815084908268.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815_8be56b99279c19f536343823b20c7c9a_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815_d0a398c4e610d455c94715fee07bb03b_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815_fb2868864135c054c021d3fe9aa901c6_cover_mwpm_03200403.jpeg"},{"uniquekey":"17a122471dd3f897cfed936d7c6424a1","title":"联合国专家抨击美国大肆羁押非法入境者 称其违反国际人权和难民权利准则","date":"2017-08-15 08:44","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815084447675.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815084447_faabcde210d4dc313ef2491fdfc61e94_1_mwpm_03200403.jpg"},{"uniquekey":"97f5bdc9fe17dba04440b2ee98b040e2","title":"长期23点后睡觉，小心身体这7个地方，补再多觉都没","date":"2017-08-15 08:37","category":"头条","author_name":"冷漠一哥","url":"http://mini.eastday.com/mobile/170815083720804.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_2_mwpm_03200403.jpg"},{"uniquekey":"b659f400f0a7bbab301ef4fd3eb0f01b","title":"瘦下来还有肥胖纹，怎么回事？2个方法消除肥胖纹","date":"2017-08-15 08:36","category":"头条","author_name":"济南业鼎医疗","url":"http://mini.eastday.com/mobile/170815083646913.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_1_mwpm_03200403.jpg"},{"uniquekey":"5138373009fb1645959b7a2952dad6a7","title":"大夫，我腰椎间盘突出了，在家能运动吗？当然能了！","date":"2017-08-15 08:36","category":"头条","author_name":"康复三皮Therapy","url":"http://mini.eastday.com/mobile/170815083623099.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_2_mwpm_03200403.jpg"},{"uniquekey":"0a4d54a34e3d2f1d3c104fdfec1b8cc4","title":"马云拿下 400 家医院，放言 30 年后医生失业、药厂消失！","date":"2017-08-15 08:33","category":"头条","author_name":"创业咖","url":"http://mini.eastday.com/mobile/170815083322083.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815083322_68ace4eca97ab354ce11066ce3dba503_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815083322_68ace4eca97ab354ce11066ce3dba503_2_mwpm_03200403.jpg"},{"uniquekey":"bc6d6af6983395bac569bc45c8b0eeba","title":"央媒评震后食客返回餐馆买单：还款照鉴出中国人诚信之本","date":"2017-08-15 08:29","category":"头条","author_name":"人民日报","url":"http://mini.eastday.com/mobile/170815082947278.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815082947_18dff1a2b42fb5e0e7711dda773d3db7_1_mwpm_03200403.jpg"},{"uniquekey":"fd3bfc1d7191f5e2e1f68f929ea89f55","title":"外媒：俄罗斯飞行员纷纷跳槽中国 留也留不住","date":"2017-08-15 08:24","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815082436292.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815082436_a3ee214ab8f9a9a57cb8ce5ff695bf46_1_mwpm_03200403.jpg"},{"uniquekey":"09c5bcba0e6430afcdd5e5ddd34940d7","title":"《战狼2》带火动作片 《破局》《杀破狼3》能否接棒","date":"2017-08-15 08:21","category":"头条","author_name":"北京晨报","url":"http://mini.eastday.com/mobile/170815082134342.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815082134_de7d2692ab5748d4396fe90ebd22f2ac_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815082134_de7d2692ab5748d4396fe90ebd22f2ac_2_mwpm_03200403.jpg"},{"uniquekey":"44d093aacdee09ae0cb1abcd3746ec47","title":"试射一万公里射程导弹 只飞200公里就炸了 对外却称大获成功","date":"2017-08-15 08:16","category":"头条","author_name":"扒姐观察室","url":"http://mini.eastday.com/mobile/170815081651735.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815_e79c123489e7318d491d6e5c0cba203f_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170815/20170815_8b7e4ca59709e3227eb78758dbd2b609_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170815/20170815_252bba9330088b7f93a5a06f329cda72_cover_mwpm_03200403.jpeg"},{"uniquekey":"485fb78658e3b7016bedce33924e6f31","title":"装弹上膛，准备开火，特朗普再放狠话要对朝动武，结果却摊上大事","date":"2017-08-15 08:12","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/170815081230617.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815_7d7a6128450bf37dc6b4f06a0ec32404_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815_77b1a6e9816ab78876cb1846e9969ea0_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170815/20170815_045efb3c3fa083c008bc4ec576845c2c_cover_mwpm_03200403.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"01f3ac363127f487c6a7612a0f1e5039","title":"记者走访印度医院 6天60名儿童死亡医院仍在运营 ","date":"2017-08-15 09:45","category":"头条","author_name":"东方IC","url":"http://mini.eastday.com/mobile/170815094524277.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_2_mwpm_03200403.jpg"},{"uniquekey":"a43c21c76980ba2e0d4413afbb3738b3","title":"\u201c科学\u201d号卡罗琳海山发现\u201c永恒爱情\u201d海绵","date":"2017-08-15 09:57","category":"头条","author_name":"新华社","url":"http://mini.eastday.com/mobile/170815095755223.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815095755_1a6e03fb91f57aadde47c10c2391c5f1_1_mwpm_03200403.jpg"},{"uniquekey":"27571de96ed5892379aeb847faf828ad","title":"\u201c台杂\u201d还是\u201c日杂�？\u201c台湾民政府\u201d成员在靖国神社参拜入口处兴高采烈拍照","date":"2017-08-15 09:55","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815095528354.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815095528_1e5c1a3fa3fe84d57c5eafc6775316ef_1_mwpm_03200403.jpg"},{"uniquekey":"4a7fb83753b2ee8df0d37c96c7849745","title":"文在寅喊话美国：未经韩同意不得动武 朝核问题必须和平解决","date":"2017-08-15 09:55","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815095527993.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815095527_72d4b7bf254122bf6eb01ea42b706e34_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815095527_72d4b7bf254122bf6eb01ea42b706e34_2_mwpm_03200403.jpg"},{"uniquekey":"1831101a90198c963edf25b1a0bd4a28","title":"山西和顺一煤矿矿难 至少4人死亡5人失踪","date":"2017-08-15 09:34","category":"头条","author_name":"中国之声","url":"http://mini.eastday.com/mobile/170815093433536.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815093433_0dd215abdedb84559f87415a2442ec11_1_mwpm_03200403.jpg"},{"uniquekey":"7d8c58946ddfb200d3b5a40c82cb8b22","title":"日本6在野党派战败日发声明：表明反省才是对战亡者的悼念","date":"2017-08-15 09:26","category":"头条","author_name":"人民网","url":"http://mini.eastday.com/mobile/170815092640107.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815092640_64e46c111f1a22c27a3a9f32e7273d8c_1_mwpm_03200403.jpg"},{"uniquekey":"09cdc028e73b3f792dedf9d333659ac1","title":"塞拉利昂首都泥石流致死人数已上升至逾300人","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092514546.html","thumbnail_pic_s":"http://04.imgmini.eastday.com/mobile/20170815/20170815092514_1017d9e5b237db3b5ddb6f3c887559d6_1_mwpm_03200403.jpg"},{"uniquekey":"d5ab2477b427aac4879a60aca3c1dac5","title":"布基纳法索遭遇疑似恐袭 法总统力挺布国反恐","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092514490.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815092514_dc1e562623b800e242a4a783d344d93e_1_mwpm_03200403.jpg"},{"uniquekey":"65395bf9ae1c27cc4c9a94bcf35f3389","title":"蒂勒森发表声明庆祝韩国光复72周年 寄语两国关系发展","date":"2017-08-15 09:25","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815092513492.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815092513_9de43d46173956b0967cbbde3eceb1c5_1_mwpm_03200403.jpg"},{"uniquekey":"2da2a647be12781f433b1959ff33f501","title":"疑有自杀倾向男子驾车冲撞餐馆致1死多伤，法国检方排除恐袭","date":"2017-08-15 09:18","category":"头条","author_name":"澎湃新闻网","url":"http://mini.eastday.com/mobile/170815091825211.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170815/20170815091825_213d06ab5555381fa2ea4187597d6e98_1_mwpm_03200403.jpg"},{"uniquekey":"6c71ad447ed4738f4c42e85bd42762f8","title":"安倍在山口县老家视察机动车加氢站 意在落实政府举措","date":"2017-08-15 09:15","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815091509335.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815091509_8becec55818ddc0ae40c0d7c08ea3b73_1_mwpm_03200403.jpg"},{"uniquekey":"819b71dbfec36fc1cd7686dc7848f14b","title":"日初中因采用涉慰安妇教材遭抗议 韩教授致信表感谢","date":"2017-08-15 09:15","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815091508516.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815091508_25c82d8133c12944da1134c17ca83ba1_1_mwpm_03200403.jpg"},{"uniquekey":"a48c5dba1f8b28dabe4b2aa10e67f11c","title":"8月份底财神眷顾，八方来财，富甲一方的3大生肖属相！","date":"2017-08-15 09:07","category":"头条","author_name":"吉名轩八字星座","url":"http://mini.eastday.com/mobile/170815090742894.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815_5ea833f6a284e6701dce293000428816_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815_6ecc964571dd3eb63896dbb0f2c67b46_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815_adc6d27a2e8899897cac069464ca7302_cover_mwpm_03200403.jpeg"},{"uniquekey":"4157bf2167ac0188daa915a0f8bc239f","title":"又逢\u201c8·15\u201d 重温72年前抗战胜利的喜悦","date":"2017-08-15 09:05","category":"头条","author_name":"中国军网","url":"http://mini.eastday.com/mobile/170815090501683.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_16_mwpm_03200403.jpg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_15_mwpm_03200403.jpg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815090501_9e0783e7d1f2981fdad4306872c1fcac_10_mwpm_03200403.jpg"},{"uniquekey":"211075240e5101c94beb56a78f452364","title":"韩美防长拟提前举行首次会晤 谈修改导弹指南等","date":"2017-08-15 09:05","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815090501103.html","thumbnail_pic_s":"http://07.imgmini.eastday.com/mobile/20170815/20170815090501_dd4f3a04e584d22380250ab8c1d890d3_1_mwpm_03200403.jpg"},{"uniquekey":"ba26dce70bfb97ac3560cb11ecf40180","title":"呼吁和平！印巴歌手异地合唱　混合版\u201c国歌\u201d网上爆红","date":"2017-08-15 09:05","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815090500940.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815090500_53c91a6e24c3e865bcc02830593f1701_1_mwpm_03200403.jpg"},{"uniquekey":"9868e9c7d45b1aa80515acdcebe81ec1","title":"日本这家电视台播了一部震惊全日本的节目，在网上遭疯狂围攻！","date":"2017-08-15 09:04","category":"头条","author_name":"环球时报","url":"http://mini.eastday.com/mobile/170815090459039.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_12_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_10_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815090459_d257956537de52848b19088e46c1b338_13_mwpm_03200403.jpg"},{"uniquekey":"d78a7666f2695acee55c3443295faece","title":"气温计爆表 边防女兵抗50℃高温站军姿","date":"2017-08-15 09:04","category":"头条","author_name":"视觉中国","url":"http://mini.eastday.com/mobile/170815090458906.html","thumbnail_pic_s":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_4_mwpm_03200403.jpg","thumbnail_pic_s02":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_2_mwpm_03200403.jpg","thumbnail_pic_s03":"http://03.imgmini.eastday.com/mobile/20170815/20170815090458_cc3eaf7495c3ec437dda1b241d0e42f2_1_mwpm_03200403.jpg"},{"uniquekey":"fdb1b9bcfd75c598abe2d7b32ed85403","title":"19岁怀爷爷的种！一家四口全是禽兽，侵犯姐妹花长达5年","date":"2017-08-15 09:04","category":"头条","author_name":"买菜的老王","url":"http://mini.eastday.com/mobile/170815090416330.html","thumbnail_pic_s":"http://02.imgmini.eastday.com/mobile/20170815/20170815_fc2d0886f5461035c0cd3ef471759e73_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://02.imgmini.eastday.com/mobile/20170815/20170815_b0b91b21a3c2c5950202c18454f18d6c_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://02.imgmini.eastday.com/mobile/20170815/20170815_76b0efdca02e2c5ff7eaf1c80aa786fc_cover_mwpm_03200403.jpeg"},{"uniquekey":"981d16cf65da2a6c23a4efec2d3c710e","title":"儿媳照顾公公同住一屋子，生活场景曝光后，网友怒赞","date":"2017-08-15 08:49","category":"头条","author_name":"图看世界","url":"http://mini.eastday.com/mobile/170815084908268.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815_8be56b99279c19f536343823b20c7c9a_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://00.imgmini.eastday.com/mobile/20170815/20170815_d0a398c4e610d455c94715fee07bb03b_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://00.imgmini.eastday.com/mobile/20170815/20170815_fb2868864135c054c021d3fe9aa901c6_cover_mwpm_03200403.jpeg"},{"uniquekey":"17a122471dd3f897cfed936d7c6424a1","title":"联合国专家抨击美国大肆羁押非法入境者 称其违反国际人权和难民权利准则","date":"2017-08-15 08:44","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815084447675.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815084447_faabcde210d4dc313ef2491fdfc61e94_1_mwpm_03200403.jpg"},{"uniquekey":"97f5bdc9fe17dba04440b2ee98b040e2","title":"长期23点后睡觉，小心身体这7个地方，补再多觉都没","date":"2017-08-15 08:37","category":"头条","author_name":"冷漠一哥","url":"http://mini.eastday.com/mobile/170815083720804.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_4_mwpm_03200403.jpg","thumbnail_pic_s03":"http://01.imgmini.eastday.com/mobile/20170815/20170815083720_9c2ed2188e01b120c61b20e1ed9a58f3_2_mwpm_03200403.jpg"},{"uniquekey":"b659f400f0a7bbab301ef4fd3eb0f01b","title":"瘦下来还有肥胖纹，怎么回事？2个方法消除肥胖纹","date":"2017-08-15 08:36","category":"头条","author_name":"济南业鼎医疗","url":"http://mini.eastday.com/mobile/170815083646913.html","thumbnail_pic_s":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_2_mwpm_03200403.jpg","thumbnail_pic_s02":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_3_mwpm_03200403.jpg","thumbnail_pic_s03":"http://08.imgmini.eastday.com/mobile/20170815/20170815083646_d52c61f44a114b9a1c758d169c0852e1_1_mwpm_03200403.jpg"},{"uniquekey":"5138373009fb1645959b7a2952dad6a7","title":"大夫，我腰椎间盘突出了，在家能运动吗？当然能了！","date":"2017-08-15 08:36","category":"头条","author_name":"康复三皮Therapy","url":"http://mini.eastday.com/mobile/170815083623099.html","thumbnail_pic_s":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_3_mwpm_03200403.jpg","thumbnail_pic_s02":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_1_mwpm_03200403.jpg","thumbnail_pic_s03":"http://09.imgmini.eastday.com/mobile/20170815/20170815083623_3560cb8f6b9ec1ee5a95a6be58596b3a_2_mwpm_03200403.jpg"},{"uniquekey":"0a4d54a34e3d2f1d3c104fdfec1b8cc4","title":"马云拿下 400 家医院，放言 30 年后医生失业、药厂消失！","date":"2017-08-15 08:33","category":"头条","author_name":"创业咖","url":"http://mini.eastday.com/mobile/170815083322083.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815083322_68ace4eca97ab354ce11066ce3dba503_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815083322_68ace4eca97ab354ce11066ce3dba503_2_mwpm_03200403.jpg"},{"uniquekey":"bc6d6af6983395bac569bc45c8b0eeba","title":"央媒评震后食客返回餐馆买单：还款照鉴出中国人诚信之本","date":"2017-08-15 08:29","category":"头条","author_name":"人民日报","url":"http://mini.eastday.com/mobile/170815082947278.html","thumbnail_pic_s":"http://01.imgmini.eastday.com/mobile/20170815/20170815082947_18dff1a2b42fb5e0e7711dda773d3db7_1_mwpm_03200403.jpg"},{"uniquekey":"fd3bfc1d7191f5e2e1f68f929ea89f55","title":"外媒：俄罗斯飞行员纷纷跳槽中国 留也留不住","date":"2017-08-15 08:24","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170815082436292.html","thumbnail_pic_s":"http://00.imgmini.eastday.com/mobile/20170815/20170815082436_a3ee214ab8f9a9a57cb8ce5ff695bf46_1_mwpm_03200403.jpg"},{"uniquekey":"09c5bcba0e6430afcdd5e5ddd34940d7","title":"《战狼2》带火动作片 《破局》《杀破狼3》能否接棒","date":"2017-08-15 08:21","category":"头条","author_name":"北京晨报","url":"http://mini.eastday.com/mobile/170815082134342.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815082134_de7d2692ab5748d4396fe90ebd22f2ac_1_mwpm_03200403.jpg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815082134_de7d2692ab5748d4396fe90ebd22f2ac_2_mwpm_03200403.jpg"},{"uniquekey":"44d093aacdee09ae0cb1abcd3746ec47","title":"试射一万公里射程导弹 只飞200公里就炸了 对外却称大获成功","date":"2017-08-15 08:16","category":"头条","author_name":"扒姐观察室","url":"http://mini.eastday.com/mobile/170815081651735.html","thumbnail_pic_s":"http://05.imgmini.eastday.com/mobile/20170815/20170815_e79c123489e7318d491d6e5c0cba203f_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://05.imgmini.eastday.com/mobile/20170815/20170815_8b7e4ca59709e3227eb78758dbd2b609_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://05.imgmini.eastday.com/mobile/20170815/20170815_252bba9330088b7f93a5a06f329cda72_cover_mwpm_03200403.jpeg"},{"uniquekey":"485fb78658e3b7016bedce33924e6f31","title":"装弹上膛，准备开火，特朗普再放狠话要对朝动武，结果却摊上大事","date":"2017-08-15 08:12","category":"头条","author_name":"第一军情","url":"http://mini.eastday.com/mobile/170815081230617.html","thumbnail_pic_s":"http://06.imgmini.eastday.com/mobile/20170815/20170815_7d7a6128450bf37dc6b4f06a0ec32404_cover_mwpm_03200403.jpeg","thumbnail_pic_s02":"http://06.imgmini.eastday.com/mobile/20170815/20170815_77b1a6e9816ab78876cb1846e9969ea0_cover_mwpm_03200403.jpeg","thumbnail_pic_s03":"http://06.imgmini.eastday.com/mobile/20170815/20170815_045efb3c3fa083c008bc4ec576845c2c_cover_mwpm_03200403.jpeg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : 01f3ac363127f487c6a7612a0f1e5039
             * title : 记者走访印度医院 6天60名儿童死亡医院仍在运营
             * date : 2017-08-15 09:45
             * category : 头条
             * author_name : 东方IC
             * url : http://mini.eastday.com/mobile/170815094524277.html
             * thumbnail_pic_s : http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_1_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_4_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://01.imgmini.eastday.com/mobile/20170815/20170815094524_a107bdedccf07b61b20a7dc540dde379_2_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }
}
