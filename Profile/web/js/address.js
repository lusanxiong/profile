/*************************************************
*全国各城市数组
**************************************************/
var address=new Array();
var addressCount=426;
address[0]=new Array("0100","","北京","beijing","beijing","B")
address[1]=new Array("0101","0100","西城区","xichengqu","xichengqu","")
address[2]=new Array("0102","0100","东城区","dongchengqu","dongchengqu","")
address[3]=new Array("0103","0100","崇文区","chongwenqu","chongwenqu","")
address[4]=new Array("0104","0100","宣武区","xuanwuqu","xuanwuqu","")
address[5]=new Array("0105","0100","朝阳区","zhaoyangqu","zhaoyangqu","")
address[6]=new Array("0106","0100","丰台区","fengtaiqu","fengtaiqu","")
address[7]=new Array("0107","0100","石景山区","shijingshanqu","shijingshanqu","")
address[8]=new Array("0108","0100","海淀区","haidianqu","haidianqu","")
address[9]=new Array("0109","0100","房山区","fangshanqu","fangshanqu","")
address[10]=new Array("0110","0100","通州区","tongzhouqu","tongzhouqu","")
address[11]=new Array("0111","0100","昌平区","changpingqu","changpingqu","")
address[12]=new Array("0112","0100","大兴区","daxingqu","daxingqu","")
address[13]=new Array("0200","","上海","shanghai","shanghai","S")
address[14]=new Array("0201","0200","黄浦区","huangpuqu","huangpuqu","")
address[15]=new Array("0202","0200","卢湾区","luwanqu","luwanqu","")
address[16]=new Array("0203","0200","徐汇区","xuHuiqu","xuHuiqu","")
address[17]=new Array("0205","0200","静安区","jinganqu","jinganqu","")
address[18]=new Array("0206","0200","普陀区","putuoqu","putuoqu","")
address[19]=new Array("0207","0200","闸北区","zhabeiqu","zhabeiqu","")
address[20]=new Array("0208","0200","虹口区","hongkouqu","hongkouqu","")
address[21]=new Array("0209","0200","杨浦区","yangpuqu","yangpuqu","")
address[22]=new Array("0210","0200","浦东新区","pudongxingqu","pudongxingqu","")
address[23]=new Array("0211","0200","闵行区","minhangqu","minhangqu","")
address[24]=new Array("0212","0200","宝山区","baoshanqu","baoshanqu","")
address[25]=new Array("0213","0200","嘉定区","jiadingqu","jiadingqu","")
address[26]=new Array("0214","0200","松江区","songjiangqu","songjiangqu","")
address[27]=new Array("0215","0200","近郊","jinjiao","jinjiao","")
address[28]=new Array("0300","","广东","guangdong","guangdong","A-G")
address[29]=new Array("030200","0300","广州","guangzhou","guangzhou","G")
address[30]=new Array("030201","030200","越秀区","yuexiuqu","yuexiuqu","")
address[31]=new Array("030202","030200","荔湾区","liwanqu","liwanqu","")
address[32]=new Array("030203","030200","海珠区","haizhuqu","haizhuqu","")
address[33]=new Array("030204","030200","天河区","tianhequ","tianhequ","")
address[34]=new Array("030205","030200","白云区","baiyunqu","baiyunqu","")
address[35]=new Array("030207","030200","番禺区","panyuqu","panyuqu","")
address[36]=new Array("030208","030200","花都区","huaduqu","huaduqu","")
address[37]=new Array("030209","030200","南沙区","nangshaqu","nangshaqu","")
address[38]=new Array("030211","0302","增城","zengcheng","zhengcheng","")
address[39]=new Array("030212","030200","萝岗区","luogangqu","luogangqu","")
address[40]=new Array("0303","0300","惠州","huizhou","huizhou","")
address[41]=new Array("0304","0300","汕头","shantou","shantou","")
address[42]=new Array("0305","0300","珠海","zhuhai","zhuhai","Z")
address[43]=new Array("0306","0300","佛山","foshan","foshan","F")
address[44]=new Array("0307","0300","中山","zhongshan","zhongshan","Z")
address[45]=new Array("0308","0300","东莞","dongguan","dongguan","D")
address[46]=new Array("0309","0300","韶关","shaoguan","shaoguan","")
address[47]=new Array("0310","0300","江门","jiangmen","jiangmen","")
address[48]=new Array("031100","0300","深圳","shenzhen","shenzhen","S")
address[49]=new Array("031149","031100","宝安区","baoanqu","baoanqu","")
address[50]=new Array("031112","031100","福田区","futianqu","futianqu","")
address[51]=new Array("031113","031100","罗湖区","luohuqu","luohuqu","")
address[52]=new Array("031114","031100","南山区","nanshanqu","nanshanqu","")
address[53]=new Array("031115","031100","盐田区","yantianqu","yantianqu","")
address[54]=new Array("031116","031100","龙岗区","longgangqu","longgangqu","")
address[55]=new Array("031150","031100","光明区","guangmingqu","guangmingqu","")
address[56]=new Array("0317","0300","潮州","chaozhou","chaozhou","")
address[57]=new Array("0318","0300","河源","heyuan","heyuan","")
address[58]=new Array("0319","0300","揭阳","jieyang","jieyang","")
address[59]=new Array("0320","0300","茂名","maoming","maoming","")
address[60]=new Array("0321","0300","汕尾","shanwei","shanwei","")
address[61]=new Array("0322","0300","顺德","shuide","shuide","")
address[62]=new Array("03301","3300","香港特别行政区","hongkong","hongkong","")
address[63]=new Array("03401","3400","澳门特别行政区","macao","macao","")
address[64]=new Array("0500","","天津","Tianjin","Tianjin","T")
address[65]=new Array("0600","","重庆","chongqing","chongqing","C")
address[66]=new Array("0700","","江苏","jiangsu","jiangsu","H-J")
address[67]=new Array("0702","0700","南京","nanjing","nanjing","N")
address[68]=new Array("0703","0700","苏州","suzhou","suzhou","S")
address[69]=new Array("0704","0700","无锡","wuxi","wuxi","W")
address[70]=new Array("0705","0700","常州","changzhou","changzhou","C")
address[71]=new Array("0706","0700","昆山","kunshan","kunshan","K")
address[72]=new Array("0707","0700","常熟","changshu","changshu","")
address[73]=new Array("0708","0700","扬州","yangzhou","yangzhou","Y")
address[74]=new Array("0709","0700","南通","nantong","nantong","N")
address[75]=new Array("0710","0700","镇江","zhenjiang","zhenjiang","Z")
address[76]=new Array("0711","0700","徐州","xuzhou","xuzhou","X")
address[77]=new Array("0712","0700","连云港","lianyungang","lianyungang","")
address[78]=new Array("0713","0700","盐城","yancheng","yancheng","")
address[79]=new Array("0714","0700","张家港","zhangjiagang","zhangjiagang","")
address[80]=new Array("0800","","浙江","zhejiang","zhejiang","T-Z")
address[81]=new Array("0802","0800","杭州","hangzhou","hangzhou","H")
address[82]=new Array("0803","0800","宁波","ningbo","ningbo","N")
address[83]=new Array("0804","0800","温州","wenzhou","wenzhou","W")
address[84]=new Array("0805","0800","绍兴","shaoxing","shaoxing","S")
address[85]=new Array("0806","0800","金华","jinghua","jinghua","J")
address[86]=new Array("0807","0800","嘉兴","jiaxing","jiaxing","J")
address[87]=new Array("0808","0800","台州","taizhou","taizhou","T")
address[88]=new Array("0809","0800","湖州","huzhou","huzhou","")
address[89]=new Array("0810","0800","丽水","lishui","lishui","")
address[90]=new Array("0811","0800","舟山","zhoushan","zhoushan","")
address[91]=new Array("0812","0800","衢州","quzhou","quzhou","")
address[92]=new Array("0900","","四川","sichuan","sichuan","L-S")
address[93]=new Array("0902","0900","成都","chengdu","chengdu","C")
address[94]=new Array("0903","0900","绵阳","mianyang","mianyang","")
address[95]=new Array("0904","0900","乐山","leshan","leshan","")
address[96]=new Array("0905","0900","泸州","luzhou","luzhou","")
address[97]=new Array("0906","0900","德阳","deyang","deyang","")
address[98]=new Array("0907","0900","宜宾","yibin","yibin","")
address[99]=new Array("0908","0900","自贡","zigong","zigong","")
address[100]=new Array("0909","0900","内江","neijiang","neijiang","")
address[101]=new Array("0910","0900","攀枝花","panzhihua","panzhihua","")
address[102]=new Array("1000","","海南","hainan","hainan","H-J")
address[103]=new Array("1002","1000","海口","haikou","haikou","H")
address[104]=new Array("1003","1000","三亚","sanya","sanya","S")
address[105]=new Array("1100","","福建","fujian","fujian","A-G")
address[106]=new Array("1102","1100","福州","fuzhou","fuzhou","F")
address[107]=new Array("1103","1100","厦门","xiamen","xiamen","X")
address[108]=new Array("1104","1100","泉州","quanzhou","quanzhou","Q")
address[109]=new Array("1105","1100","漳州","zhangzhou","zhangzhou","Z")
address[110]=new Array("1106","1100","莆田","putian","putian","")
address[111]=new Array("1107","1100","三明","sanming","sanming","")
address[112]=new Array("1108","1100","南平","nanping","nanping","")
address[113]=new Array("1109","1100","宁德","ningde","ningde","")
address[114]=new Array("1110","1100","龙岩","longyan","longyan","")
address[115]=new Array("1200","","山东","shandong","shandong","L-S")
address[116]=new Array("1202","1200","济南","jinan","jinan","J")
address[117]=new Array("1203","1200","青岛","qingdao","qingdao","Q")
address[118]=new Array("1204","1200","烟台","yantai","yantai","Y")
address[119]=new Array("1205","1200","潍坊","weifang","weifang","")
address[120]=new Array("1206","1200","威海","weihai","weihai","")
address[121]=new Array("1207","1200","淄博","zibo","zibo","")
address[122]=new Array("1208","1200","临沂","linyi","linyi","")
address[123]=new Array("1209","1200","济宁","jining","jining","")
address[124]=new Array("1210","1200","东营","dongying","dongying","")
address[125]=new Array("1211","1200","泰安","taian","taian","")
address[126]=new Array("1212","1200","日照","rizhao","rizhao","")
address[127]=new Array("1213","1200","德州","dezhou","dezhou","")
address[128]=new Array("1300","","江西","jiangxi","jiangxi","H-J")
address[129]=new Array("1302","1300","南昌","nanchang","nanchang","")
address[130]=new Array("1303","1300","九江","jiujiang","jiujiang","")
address[131]=new Array("1400","","广西","guangxi","guangxi","A-G")
address[132]=new Array("1402","1400","南宁","nanning","nanning","N")
address[133]=new Array("1403","1400","桂林","guilin","guilin","")
address[134]=new Array("1404","1400","柳州","liuzhou","liuzhou","")
address[135]=new Array("1405","1400","北海","beihai","beihai","")
address[136]=new Array("1500","","安徽","anhui","anhui","A-G")
address[137]=new Array("1502","1500","合肥","hefei","hefei","H")
address[138]=new Array("1503","1500","芜湖","wuhu","wuhu","")
address[139]=new Array("1504","1500","安庆","anqing","anqing","")
address[140]=new Array("1505","1500","马鞍山","maanshan","maanshan","")
address[141]=new Array("1506","1500","蚌埠","bangbushi","bangbushi","")
address[142]=new Array("1507","1500","阜阳","fuyang","fuyang","")
address[143]=new Array("1508","1500","铜陵","tongling","tongling","")
address[144]=new Array("1509","1500","滁州","chuzhou","chuzhou","")
address[145]=new Array("1510","1500","黄山","huangshan","huangshan","")
address[146]=new Array("1511","1500","淮南","huainan","huainan","")
address[147]=new Array("1512","1500","六安","liuan","liuan","")
address[148]=new Array("1513","1500","巢湖","chaohu","chaohu","")
address[149]=new Array("1514","1500","宣城","xuancheng","xuancheng","")
address[150]=new Array("1515","1500","池州","chizhou","chizhou","")
address[151]=new Array("1600","","河北","hebei","hebei","H-J")
address[152]=new Array("1602","1600","石家庄","shijiazhuang","shijiazhuang","S")
address[153]=new Array("1603","1600","廊坊","langfang","langfang","")
address[154]=new Array("1604","1600","保定","baoding","baoding","")
address[155]=new Array("1605","1600","唐山","tangshan","tangshan","")
address[156]=new Array("1606","1600","秦皇岛","qinhuangdao","qinhuangdao","")
address[157]=new Array("1700","","河南","henan","henan","H-J")
address[158]=new Array("1702","1700","郑州","zhengzhou","zhengzhou","Z")
address[159]=new Array("1703","1700","洛阳","luoyang","luoyang","")
address[160]=new Array("1704","1700","开封","kaifeng","kaifeng","")
address[161]=new Array("1800","","湖北","hubei","hubei","H-J")
address[162]=new Array("1802","1800","武汉","wuhan","wuhan","W")
address[163]=new Array("1803","1800","宜昌","yichang","yichang","")
address[164]=new Array("1804","1800","黄石","huangshi","huangshi","")
address[165]=new Array("1805","1800","襄樊","xiangfan","xiangfan","")
address[166]=new Array("1806","1800","十堰","shiyan","shiyan","")
address[167]=new Array("1807","1800","荆州","jingzhou","jingzhou","")
address[168]=new Array("1808","1800","荆门","jingmen","jingmen","")
address[169]=new Array("1809","1800","孝感","xiaogan","xiaogan","")
address[170]=new Array("1810","1800","鄂州","ezhou","ezhou","")
address[171]=new Array("1900","","湖南","hunan","hunan","H-J")
address[172]=new Array("1902","1900","长沙","changsha","changsha","C")
address[173]=new Array("1903","1900","株洲","zhuzhou","zhuzhou","")
address[174]=new Array("1904","1900","湘潭","xiangtan","xiangtan","")
address[175]=new Array("1905","1900","衡阳","hengyang","hengyang","")
address[176]=new Array("1906","1900","岳阳","yueyang","yueyang","")
address[177]=new Array("1907","1900","常德","changde","changde","")
address[178]=new Array("1908","1900","益阳","yiyang","yiyang","")
address[179]=new Array("1909","1900","郴州","chenzhou","chenzhou","")
address[180]=new Array("1910","1900","邵阳","shaoyang","shaoyang","")
address[181]=new Array("1911","1900","怀化","huaihua","huaihua","")
address[182]=new Array("1912","1900","娄底","loudi","loudi","")
address[183]=new Array("1913","1900","永州","yongzhou","yongzhou","")
address[184]=new Array("1914","1900","张家界","zhangjiajie","zhangjiajie","")
address[185]=new Array("2000","","陕西","shaanxi","shaanxi","L-S")
address[186]=new Array("2002","2000","西安","xian","xian","X")
address[187]=new Array("2003","2000","咸阳","xianyang","xianyang","")
address[188]=new Array("2004","2000","宝鸡","baoji","baoji","")
address[189]=new Array("2005","2000","铜川","tongchuan","tongchuan","")
address[190]=new Array("2006","2000","延安","yanan","yanan","")
address[191]=new Array("2100","","山西","shanxi","shanxi","L-S")
address[192]=new Array("2102","2100","太原","taiyuan","taiyuan","T")
address[193]=new Array("2103","2100","运城","yuncheng","yuncheng","")
address[194]=new Array("2104","2100","大同","datong","datong","")
address[195]=new Array("2105","2100","临汾","linfen","linfen","")
address[196]=new Array("2200","","黑龙江","heilongjiang","heilongjiang","H-J")
address[197]=new Array("2202","2200","哈尔滨","haerbin","haerbin","H")
address[198]=new Array("2203","2200","伊春","yichun","yichun","")
address[199]=new Array("2204","2200","绥化","suihua","suihua","")
address[200]=new Array("2205","2200","大庆","daqing","daqing","")
address[201]=new Array("2206","2200","齐齐哈尔","qiqihaer","qiqihaer","")
address[202]=new Array("2207","2200","牡丹江","mudanjiang","mudanjiang","")
address[203]=new Array("2208","2200","佳木斯","jiamusi","jiamusi","")
address[204]=new Array("2300","","辽宁","liaoning","liaoning","L-S")
address[205]=new Array("2302","2300","沈阳","shenyang","shenyang","S")
address[206]=new Array("2303","2300","大连","dalian","dalian","D")
address[207]=new Array("2304","2300","鞍山","anshan","anshan","")
address[208]=new Array("2305","2300","营口","yingkou","yingkou","")
address[209]=new Array("2306","2300","抚顺","fushun","fushun","")
address[210]=new Array("2307","2300","锦州","jinzhou","jinzhou","")
address[211]=new Array("2308","2300","丹东","dandong","dandong","")
address[212]=new Array("2309","2300","葫芦岛","huludao","huludao","")
address[213]=new Array("2310","2300","本溪","benxi","benxi","")
address[214]=new Array("2311","2300","辽阳","liaoyang","liaoyang","")
address[215]=new Array("2312","2300","铁岭","tieling","tieling","")
address[216]=new Array("2400","","吉林","jilin","jilin","H-J")
address[217]=new Array("2402","2400","长春","changchun","changchun","C")
address[218]=new Array("2403","2400","吉林","jilin","jilin","J")
address[219]=new Array("2404","2400","辽源","liaoyuan","liaoyuan","")
address[220]=new Array("2405","2400","通化","tonghua","tonghua","")
address[221]=new Array("2500","","云南","yunnan","yunnan","T-Z")
address[222]=new Array("2502","2500","昆明","kunming","kunming","K")
address[223]=new Array("2503","2500","曲靖","qujing","qujing","")
address[224]=new Array("2504","2500","玉溪","yuxi","yuxi","")
address[225]=new Array("2505","2500","大理","dali","dali","")
address[226]=new Array("2506","2500","丽江","lijiang","lijiang","")
address[227]=new Array("2507","2500","蒙自","mengzi","mengzi","")
address[228]=new Array("2508","2500","开远","kaiyuan","kaiyuan","")
address[229]=new Array("2509","2500","个旧","gejiu","gejiu","")
address[230]=new Array("2510","2500","红河州","honghezhou","honghezhou","")
address[231]=new Array("2600","","贵州","guizhou","guizhou","A-G")
address[232]=new Array("2602","2600","贵阳","guiyang","guiyang","G")
address[233]=new Array("2603","2600","遵义","zunyi","zunyi","")
address[234]=new Array("2700","","甘肃","gansu","gansu","A-G")
address[235]=new Array("2702","2700","兰州","lanzhou","lanzhou","L")
address[236]=new Array("2703","2700","金昌","jinchang","jinchang","")
address[237]=new Array("2800","","内蒙古","neimenggu","neimenggu","L-S")
address[238]=new Array("2802","2800","呼和浩特","huhehaote","huhehaote","H")
address[239]=new Array("2803","2800","赤峰","chifeng","chifeng","C")
address[240]=new Array("2804","2800","包头","baotou","baotou","B")
address[241]=new Array("2900","","宁夏","ningxia","ningxia","L-S")
address[242]=new Array("2902","2900","银川","yingchuan","yingchuan","")
address[243]=new Array("3000","","西藏","xizang","xizang","T-Z")
address[244]=new Array("3002","3000","拉萨","lasa","lasa","")
address[245]=new Array("3003","3000","日喀则","rikaze","rikaze","")
address[246]=new Array("3100","","新疆","xinjiang","xinjiang","T-Z")
address[247]=new Array("3102","3100","乌鲁木齐","wulumuqi","wulumuqi","W")
address[248]=new Array("3200","","青海","qinghai","qinghai","L-S")
address[249]=new Array("3202","3200","西宁","xining","xining","")
address[250]=new Array("3203","3200","银川","yinchuan","yinchuan","")
address[251]=new Array("3103","3100","克拉玛依","kelamayi","kelamayi","")
address[252]=new Array("3104","3100","喀什地区","kashidiqu","kashidiqu","")
address[253]=new Array("3300","","香港","hongkong","hongkong","T-Z")
address[254]=new Array("3400","","澳门","macao","macao","A-G")
address[255]=new Array("3500","","台湾","taiwan","taiwan","T-Z")
address[256]=new Array("3501","3500","台北","taibei","taibei","")
address[257]=new Array("3502","3500","台南","tainan","tainan","")
address[258]=new Array("3503","3500","基隆","jilong","jilong","")
address[259]=new Array("3504","3500","台中","taizhong","taizhong","")
address[260]=new Array("3505","3500","高雄","gaoxiong","gaoxiong","")
address[261]=new Array("3600","","国外","fremdness","fremdness","A-G")




/*台湾*/
address[262]=new Array("3507","3500","嘉义市","jiayishi","jiayishi","")
/*广东*/
address[263]=new Array("0323","0300","云浮市","Yunfu Guangdong","Yunfu","")
address[264]=new Array("0324","0300","阳江市","Yangjiang Guangdong","Yangjiang","")
/*广西*/
address[265]=new Array("1406","1400","防城港市","Fangchenggang Guangxi","Fangchenggang","")
address[266]=new Array("1407","1400","崇左市","Chongzuo Guangxi","Chongzuo","")
address[267]=new Array("1408","1400","来宾市","Laibing Guangxi","Laibing","")
address[268]=new Array("1409","1400","梧州市","Wuzhou Guangxi","Wuzhou","")
address[269]=new Array("1410","1400","贺州市","Hezhou Guangxi","Hezhou","")
address[270]=new Array("1411","1400","玉林市","Yulin Guangxi","Yulin","")
address[271]=new Array("1412","1400","贵港市","Guigang Guangxi","Guigang","")
address[272]=new Array("1413","1400","百色市","Baise Guangxi","Baise","")
address[273]=new Array("1414","1400","河池市","Hechi Guangxi","Hechi","")
address[274]=new Array("1415","1400","钦州市","Qinzhou Guangxi","Qinzhou","")
/*广东*/
address[275]=new Array("0325","0300","梅州市","Meizhou Guangxi","Meizhou","")
/*安徽*/
address[276]=new Array("1516","1500","亳州市","Haozhou Anhui","Haozhou","")
address[277]=new Array("1517","1500","淮北市","Huaibei Anhui","Huaibei","")
address[278]=new Array("1518","1500","宿州市","Suzhou Anhui","Suzhou","")
/******新疆维吾尔族自治区********/
address[279]=new Array("3109","3100","伊犁哈萨克自治州 ","yilihashakezizhizhou","yilihashakezizhizhou","")
/*贵州省*/
address[280]=new Array("2604","2600","六盘水","Liupanshui Guizhou","Liupanshui","")
address[281]=new Array("2605","2600","安顺","Anshun Guizhou","Anshun","")
address[282]=new Array("2606","2600","铜仁","Tongren Guizhou","Tongren","")
address[283]=new Array("2607","2600","毕节","Bijie Guizhou","Bijie","")
address[284]=new Array("2608","2600","黔西南","Qianxinan Guizhou","Qianxinan","")
address[285]=new Array("2609","2600","黔东南","Qiandongnan Guizhou","Qiandongnan","")
address[286]=new Array("2610","2600","黔南","Qinnan Guizhou","Qinnan","")
/*甘肃省*/
address[287]=new Array("2704","2700","白银市","Baiyin Gansu","Baiyin","")
address[288]=new Array("2705","2700","天水市","Tianshui Gansu","Tianshui","")
address[289]=new Array("2706","2700","武威市","Wuwei Gansu","Wuwei","")
address[290]=new Array("2707","2700","张掖市","Zhangye Gansu","Zhangye","")
address[291]=new Array("2708","2700","酒泉市","Jiuquan Gansu","Jiuquan","")
address[292]=new Array("2709","2700","平凉市","Pingliang Gansu","Pingliang","")
address[293]=new Array("2710","2700","庆阳市","Qingyang Gansu","Qingyang","")
address[294]=new Array("2711","2700","定西市","Dingxi Gansu","Dingxi","")
address[295]=new Array("2712","2700","陇南市","Longnan Gansu","Longnan","")
address[296]=new Array("2713","2700","临夏回族自治州","Linxiahuizu Gansu","Linxiahuizu","")
address[297]=new Array("2714","2700","甘南藏族自治州","Gannanzangzu Gansu","Gannanzangzu","")
/*江苏省*/
address[298]=new Array("0715","0700","溧水县","lishuixian","lishuixian","")
address[299]=new Array("0716","0700","高淳县","gaochunxian","gaochunxian","")
address[300]=new Array("0717","0700","淮安市","huaianshi","huaianshi","")
address[301]=new Array("0718","0700","泰州市","taizhoushi","taizhoushi","")
address[302]=new Array("0719","0700","宿迁市","suqianshi","suqianshi","")
address[303]=new Array("0720","0700","吴江市","wujiangshi","wujiangshi","")
/*江西省*/
address[304]=new Array("1304","1300","上饶市","shangraoshi","shangraoshi","")
address[305]=new Array("1305","1300","宜春市","yichunshi","yichunshi","")
address[306]=new Array("1306","1300","景德镇市","jingdezhenshi","jingdezhenshi","")
address[307]=new Array("1307","1300","萍乡市","pingxiangshi","pingxiangshi","")
address[308]=new Array("1308","1300","鹰潭市","yingtanshi","yingtanshi","")
address[309]=new Array("1309","1300","赣州市","ganzhoushi","ganzhoushi","")
address[310]=new Array("1310","1300","吉安市","ji‘anshi","ji‘anshi","")
address[311]=new Array("1311","1300","抚州市","fuzhoushi","fuzhoushi","")
address[312]=new Array("1312","1300","新余市","xinyushi","xinyushi","")
/*陕西省*/
address[313]=new Array("2007","2000","榆林市","yuyinshi","yuyinshi","")
address[314]=new Array("2008","2000","渭南市","weinanshi","weinanshi","")
address[315]=new Array("2009","2000","汉中市","hanzhongshi","hanzhongshi","")
address[316]=new Array("2010","2000","安康市","ankangshi","ankangshi","")
address[317]=new Array("2011","2000","商洛市","shangluoshi","shangluoshi","")
address[318]=new Array("2012","2000","杨凌示范区","yanglinshifanqun","yanglinshifanqun","")
/*山西省*/
address[319]=new Array("2106","2100","阳泉市","yangquanshi","yangquanshi","")
address[320]=new Array("2107","2100","长治市","changzhishi","changzhishi","")
address[321]=new Array("2108","2100","晋城市","jinchengshi","jinchengshi","")
address[322]=new Array("2109","2100","朔州市","shuozhoushi","shuozhoushi","")
address[323]=new Array("2110","2100","晋中市","jinzhongshi","jinzhongshi","")

address[324]=new Array("2112","2100","吕梁市","lvliangshi","lvliangshi","")
/*河北省*/
address[325]=new Array("1607","1600","邯郸市","handanshi","handanshi","")
address[326]=new Array("1608","1600","承德市","chengdeshi","chengdeshi","")
address[327]=new Array("1609","1600","沧州市","cangzhoushi","cangzhoushi","")
address[328]=new Array("1610","1600","衡水市","hengshuishi","hengshuishi","")
address[329]=new Array("1611","1600","邢台市","xingtaishi","xingtaishi","")
address[330]=new Array("1612","1600","张家口市","zhangjiakoushi","zhangjiakoushi","")
/*河南省*/
address[331]=new Array("1705","1700","平顶山市","pingdingshanshi","pingdingshanshi","")
address[332]=new Array("1706","1700","焦作市","jiaozuoshi","jiaozuoshi","")
address[333]=new Array("1707","1700","鹤壁市 ","hebishi","hebishi","")
address[334]=new Array("1708","1700","新乡市","xinxiangshi","xinxiangshi","")
address[335]=new Array("1709","1700","安阳市","anyangshi","anyangshi","")
address[336]=new Array("1710","1700","濮阳市","puyagnshi","puyagnshi","")
address[337]=new Array("1711","1700","许昌市","xuchagnshi","xuchagnshi","")
address[338]=new Array("1712","1700","漯河市","luoheshi","luoheshi","")
address[339]=new Array("1713","1700","三门峡市","sanmenxiashi","sanmenxiashi","")
address[340]=new Array("1714","1700","南阳市","nanyangshi","nanyangshi","")
address[341]=new Array("1715","1700","商丘市","shangqiushi","shangqiushi","")
address[342]=new Array("1716","1700","信阳市","xinyangshi","xinyangshi","")
address[343]=new Array("1717","1700","周口市","zhoukoushi","zhoukoushi","")
address[344]=new Array("1718","1700","驻马店市","zhumadianshi","zhumadianshi","")
address[345]=new Array("1719","1700","济源市","jiyuanshi","jiyuanshi","")
/*湖北省*/
address[346]=new Array("1811","1800","黄冈市","huanggangshi","huanggangshi","")
address[347]=new Array("1812","1800","咸宁市","xianningshi","xianningshi","")
address[348]=new Array("1813","1800","随州市","suizhoushi","suizhoushi","")
address[349]=new Array("1814","1800","潜江市","qianjiangshi","qianjiangshi","")
address[350]=new Array("1815","1800","仙桃市","xiantaoshi","xiantaoshi","")
address[351]=new Array("1816","1800","天门市","tianmenshi","tianmenshi","")
address[352]=new Array("1817","1800","神农架林区","shennongjialinqu","shennongjialinqu","")
address[353]=new Array("1818","1800","恩施州","enshishi","enshishi","")
/*台湾*/
address[354]=new Array("3506","3500","新竹市","xinzhushi","xinzhushi","")
/*湖南*/
address[355]=new Array("1916","1900","湘西土家族苗族自治州","xiangxi","xiangxi","")

/*山西省*/
address[356]=new Array("2111","2100","忻州市","xinzhoushi","xinzhoushi","")
/*黑龙江*/
address[357]=new Array("2209","2200","大庆市","daqingshi","daqingshi","")
address[358]=new Array("2210","2200","鹤岗市","hegangshi","hegangshi","")
address[359]=new Array("2211","2200","双鸭山市","shuangyashanshi","shuangyashanshi","")
address[360]=new Array("2212","2200","鸡西市","jixishi","jixishi","")
address[361]=new Array("2213","2200","七台河市 ","qitaiheshi","qitaiheshi","")
address[362]=new Array("2214","2200","大兴安岭地区","daxinganlingqu","daxinganlingqu","")
/*吉林省*/
address[363]=new Array("2406","2400","四平市","sipingshi","sipingshi","")
address[364]=new Array("2407","2400","白山市","baishanshi","baishanshi","")
address[365]=new Array("2408","2400","松原市","songyuanshi","songyuanshi","")
address[366]=new Array("2409","2400","白城市","baichengshi","baichengshi","")
address[367]=new Array("2410","2400","延边朝鲜族自治州","yanbian","yanbian","")
/*四川省*/
address[368]=new Array("0911","0900","广元市","guangyuanshi","guangyuanshi","")
address[369]=new Array("0912","0900","遂宁市","suiningshi","suiningshi","")
address[370]=new Array("0913","0900","南充市","nanchongshi","nanchongshi","")
address[371]=new Array("0914","0900","广安市","guanganshi","guanganshi","")
address[372]=new Array("0915","0900","达州市","dazhoushi","dazhoushi","")
address[373]=new Array("0916","0900","眉山市","meishanshi","meishanshi","")
address[374]=new Array("0917","0900","雅安市","yaanshi","yaanshi","")
address[375]=new Array("0918","0900","巴中市","bazhongshi","bazhongshi","")
address[376]=new Array("0919","0900","资阳市","ziyangshi","ziyangshi","")
address[377]=new Array("0920","0900","阿坝州","abazhou","abazhou","")
address[378]=new Array("0921","0900","甘孜州","ganzizhou","ganzizhou","")
address[379]=new Array("0922","0900","凉山州","liangshanzhou","liangshanzhou","")
/*山东省*/
address[380]=new Array("1214","1200","莱芜市","laiwushi","laiwushi","")
address[381]=new Array("1215","1200","枣庄市","zaozhuangshi","zaozhuangshi","")
address[382]=new Array("1216","1200","聊城市","liaocheng","liaocheng","")
address[383]=new Array("1217","1200","菏泽市","hezeshi","hezeshi","")
address[384]=new Array("1218","1200","滨州市 ","binzhoushi","binzhoushi","")
/*辽宁省*/
address[385]=new Array("2313","2300","盘锦市","panjinshi","panjinshi","")
address[386]=new Array("2314","2300","阜新市 ","fuxinshi","fuxinshi","")
address[387]=new Array("2315","2300","朝阳市","chaoyangshi","chaoyangshi","")
/*内蒙古自治区*/
address[388]=new Array("2805","2800","乌海市","wuhaishi","wuhaishi","")
address[389]=new Array("2806","2800","通辽市","tongliaoshi","tongliaoshi","")
address[390]=new Array("2807","2800","鄂尔多斯市","eerduosishi","eerduosishi","")
address[391]=new Array("2808","2800","呼伦贝尔市","hulunbeiershi","hulunbeiershi","")
address[392]=new Array("2809","2800","巴彦淖尔市","bayanzhuoershi","bayanzhuoershi","")
address[393]=new Array("2810","2800","乌兰察布市","wulanchabushi","wulanchabushi","")
address[394]=new Array("2811","2800","锡林郭勒盟","xilinguolemeng","xilinguolemeng","")
address[395]=new Array("2812","2800","兴安盟","xinanmeng","xinanmeng","")
address[396]=new Array("2813","2800","阿拉善盟","alashanmeng","alashanmeng","")
/*宁夏回族自治区 */
address[397]=new Array("2903","2900","石嘴山市","shizuishanshi","shizuishanshi","")
address[398]=new Array("2904","2900","吴忠市","wuzhongshi","wuzhongshi","")
address[399]=new Array("2905","2900","固原市 ","guyuanshi","guyuanshi","")
address[400]=new Array("2906","2900","中卫市","zhongweishi","zhongweishi","")
/*青海省 */
address[401]=new Array("3204","3200","海北藏族自治州","haibei","haibei","")
address[402]=new Array("3207","3200","果洛藏族自治州","guoluozangzu","guoluozangzu","")
address[403]=new Array("3208","3200","黄南藏族自治州","huangnanzangzuzizhizhou","huangnanzangzuzizhizhou","")
address[404]=new Array("3209","3200","海南藏族自治州","hainanzangzuzizhizhou","hainanzangzuzizhizhou","")
address[405]=new Array("3210","3200","玉树藏族自治州","yushuzangzuzizhizhou","yushuzangzuzizhizhou","")
address[406]=new Array("3211","3200","海西蒙古族藏族自治州","haiximengguzuzangzuzizhizhou","haiximengguzuzangzuzizhizhou","")
/*云南省 */
address[407]=new Array("2511","2500","保山市","baoshanshi","baoshanshi","")
address[408]=new Array("2512","2500","昭通市","zhaotongshi","zhaotongshi","")
address[409]=new Array("2513","2500","思茅市","simaoshi","simaoshi","")
address[410]=new Array("2514","2500","临沧市","lincangshi","lincangshi","")
address[411]=new Array("2515","2500","文山州","wenshanzhou","wenshanzhou","")
address[412]=new Array("2516","2500","西双版纳州","xishuangbannazhou","xishuangbannazhou","")
address[413]=new Array("2517","2500","楚雄州","chuxiongzhou","chuxiongzhou","")
address[414]=new Array("2518","2500","德宏州","dehongzhou","dehongzhou","")
address[415]=new Array("2519","2500","怒江州","nujiangzhou","nujiangzhou","")
address[416]=new Array("2520","2500","迪庆州","diqingzhou","diqingzhou","")
address[417]=new Array("2521","2500","普洱市","puershi","puershi","")
/*新疆维吾尔族自治区 */
address[418]=new Array("3105","3100","克孜勒苏柯尔克自治州","kezilesukeerkezizhizhou","kezilesukeerkezizhizhou","")
address[419]=new Array("3106","3100","巴音郭楞蒙古自治州","bayinguonengmengguzizhizhou","bayinguonengmengguzizhizhou","")
address[420]=new Array("3107","3100","昌吉回族自治州","changjihuizuzizhizhou","changjihuizuzizhizhou","")
address[421]=new Array("3108","3100","博尔塔拉蒙古自治州","boertalamengguzizhizhou","boertalamengguzizhizhou","")

address[422]=new Array("0313","0300","增城市","zengchengshi","zengchengshi","")
address[423]=new Array("0314","0300","湛江市","zhanjiangshi","zhanjiangshi","")
address[424]=new Array("0315","0300","肇庆市","zhaoqingshi","zhaoqingshi","")
address[425]=new Array("0316","0300","清远市","qingyuanshi","qingyuanshi","")





/*
**	初始化省份
**	initObj:初始化对象
*/
function initProv(initObj){
	opt=document.createElement("OPTION");
	initObj.length=1;
	//addresCount ：城市个数
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第一个元素
		var subStrFirst=subArray[1];	
		if(subStrFirst==""){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2];
			initObj.add(opt);
		}
	}
}
/*
**	初始化城市
**	initObj:初始化对象
*/
function initCity(initObj,parentsId){
	opt=document.createElement("OPTION");
	initObj.length=0;
	opt=document.createElement("OPTION");	opt.value=parentsId;	opt.text=getProvName(parentsId)+'-不限';	initObj.add(opt);	//addresCount ：城市个数
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		var subStrFirst=subArray[1];	
		if(subStrFirst==parentsId){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2];
			initObj.add(opt);
		}
	}
}
/*
**	以树形菜单显示地区信息
**	initObj:初始化对象
*/
function initCityTree(initObj){
	opt=document.createElement("OPTION");
	initObj.length=1;
	//addressCount ：城市个数
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第一个元素
		var subStrFirst=subArray[1];	
		var supId=subArray[0];	
		if(subStrFirst==""){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2];
			initObj.add(opt);
			getSupList(supId,initObj,0);
		}
	}
}
/*
**	加载子类别
**	initObj:初始化对象
*/
function getSupList(supId,initObj,time){
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第一个元素
		var subStrFirst=subArray[1];	
		if(subStrFirst==supId){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			if(time==0){
				opt.text="  |－"+subArray[2];
				initObj.add(opt);
			} else if(time==1){
				opt.text="   |－－"+subArray[2];
				initObj.add(opt);
			}
			getSupList(subArray[0],initObj,1);
		}
	}
}


/*
**	根据给出的省份编码
**	查找省份名称
*/
function getProvName(ProvId){
	var name="";
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[0],10);
		if(subStrFirst==ProvId){
			name=subArray[2];
			break;
		}
	}
	return name;
}


/*
**	根据给出的城市编码
**	查找城市名称
*/
function getCityName(CityId){
	var name="";
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第二个元素
		var subStrSecond=parseInt(subArray[0],10);
		if(subStrSecond==CityId){
			name=subArray[2];
			break;
		}
	}
	return name;
}
/*
**	根据给出的城市编码
**	查找城市英文名称
*/
function getCityNameen(CityId){
	var name="";
	for(var i=0;i<addressCount;i++){
		var subArray=address[i];
		//各子对象中的第二个元素
		var subStrSecond=parseInt(subArray[0],10);
		if(subStrSecond==CityId){
			name=subArray[4];
			break;
		}
	}
	return name;
}
/*
**	删除li节点
*/
 function   fnDelete(oList,checkCleanHidden,id){
	var   ochild = document.getElementById(id);
	if(ochild){
		if (checkCleanHidden != null && checkCleanHidden != "") {
		 for(var i = 1 ; i < 4; i++) {
		   if (document.getElementById("jobLocation"+ i +"_p").value == id){
		     document.getElementById("jobLocation"+ i +"_p").value ="";
			 document.getElementById("jobLocationp"+ i).value ="";			}
		  }
		}
	document.getElementById(oList).removeChild(ochild);
	}
}
