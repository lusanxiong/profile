/*************************************************
*工作类别
**************************************************/
var sort=new Array();
var sortCount=691;
sort[0]=new Array(1000,0,"计算机/IT/互联网/电子商务","Computer/IT/Internet/E-commerce",1)
sort[1]=new Array(1001,1000,"软件工程师","Software Engineer",0)
sort[2]=new Array(1107,1100,"总裁助理/总经理助理","CEO/GM/President Assistant",0)
sort[3]=new Array(1301,1300,"销售总监","Sales Director",0)
sort[4]=new Array(1101,1100,"首席执行官CEO/总裁/总经理","CEO/President/General Manager",0)
sort[5]=new Array(1401,1400,"客服总监(非技术)  ","Customer Service Director",0)
sort[6]=new Array(1501,1500,"市场/营销/拓展总监","Marketing / BD Director / VP",0)
sort[7]=new Array(1601,1600,"首席财务官 CFO ","Chief Financial Officer (CFO)",0)
sort[8]=new Array(1701,1700,"工厂经理/厂长","Plant/Factory Manager",0)
sort[9]=new Array(1801,1800,"行政总监","Admin Director",0)
sort[10]=new Array(1901,1900,"通信技术工程师","Communication Engineer",0)
sort[11]=new Array(2001,2000,"行长/副行长","President/Vice-President/Branch Manager",0)
sort[12]=new Array(2101,2100,"证券/期货/外汇经纪人","Securities Broker",0)
sort[13]=new Array(2301,2300,"技术研发经理/主管","Technical Design Mgr./Spvr.",0)
sort[14]=new Array(2401,2400,"经营/管理类 ","Operation/ Management",0)
sort[15]=new Array(2501,2500,"高级建筑工程师/总工","Senior Architect",0)
sort[16]=new Array(2201,2200,"贸易/进出口经理/主管","Trading/Imports",0)
sort[17]=new Array(2601,2600,"房地产项目/开发/策划经理","Real Estate Project/Development/Planning Manager",0)
sort[18]=new Array(2801,2800,"高级管理","Hospital Management",0)
sort[19]=new Array(2701,2700,"高级物业顾问/物业顾问","Senior Property Advisor/Property Advisor",0)
sort[20]=new Array(2901,2900,"生物工程/生物制药","Biotechnology/Pharmaceuticals",0)
sort[21]=new Array(3501,3500,"校长","School Principal",0)
sort[22]=new Array(3601,3600,"美容/化妆顾问","Beauty /Makeup Advisor",0)
sort[23]=new Array(3701,3700,"LED照明","LED Lighting",0)
sort[24]=new Array(3801,3800,"总工程师/副总工程师","Chief Engineer / Deputy Chief Engineer",0)
sort[25]=new Array(3901,3900,"总工程师/厂长","Chief Engineer / Director",0)
sort[26]=new Array(4101,4100,"物流总监","Logistics Director",0)
sort[27]=new Array(4001,4000,"飞机机长/副机长","Aircraft captain / vice captain",0)
sort[28]=new Array(3001,3000,"高级管理","Senior Management",0)
sort[29]=new Array(3101,3100,"酒店/宾馆经理","Hotel Manager",0)
sort[30]=new Array(3201,3200,"餐饮/娱乐管理","Restaurant ",0)
sort[31]=new Array(3301,3300,"化工技术/科研人员","Chemical Technology / research staff",0)
sort[32]=new Array(4301,4300,"平面设计总监","Graphic Design Director",0)
sort[33]=new Array(4401,4400,"店长/卖场经理/楼面管理","Store Manager/Floor Manager",0)
sort[34]=new Array(4501,4500,"律师/法律顾问","Lawyer/Counsel/ Legal Adviser",0)
sort[35]=new Array(3401,3400,"服装/纺织设计总监","Fashion/Textiles Design Director",0)
sort[36]=new Array(4601,4600,"技工","Technician / Engineer Trainee",0)
sort[37]=new Array(5001,5000,"场长(农/林/牧/渔业)","Culturist",0)
sort[38]=new Array(4201,4200,"电力设计类","Power Design",0)
sort[39]=new Array(4701,4700,"采购总监","Purchasing Director",0)
sort[40]=new Array(4801,4800,"英语翻译","English Translator",0)
sort[41]=new Array(4901,4900,"环保工程师","Environmental Protection Engineer",0)
sort[42]=new Array(4902,4900,"环境影响评价工程师","Environmental Impact Assessment Engineer",0)
sort[43]=new Array(4802,4800,"日语翻译","Japanese Translator",0)
sort[44]=new Array(4702,4700,"采购经理","Purchasing Manager",0)
sort[45]=new Array(5002,5000,"养殖部主管","Director(Agriculture/Forestry/Fishing)",0)
sort[46]=new Array(4602,4600,"钳工/机修工/钣金工","Locksmith/Mechanic/Repairer",0)
sort[47]=new Array(4202,4200,"电力施工/工程类","Power Construction / Engineering",0)
sort[48]=new Array(4502,4500,"律师助理","Paralegal",0)
sort[49]=new Array(4402,4400,"品类经理","Category Manager",0)
sort[50]=new Array(4302,4300,"平面设计经理/主管","Graphic Design Manager/Supervisor",0)
sort[51]=new Array(3302,3300,"涂料研发工程师","R",0)
sort[52]=new Array(3202,3200,"餐饮/娱乐领班/部长","Restaurant ",0)
sort[53]=new Array(3102,3100,"酒店/宾馆营销","Hotel Sales ",0)
sort[54]=new Array(3002,3000,"生产管理","Production management",0)
sort[55]=new Array(4002,4000,"空乘人员","Flight Attendant",0)
sort[56]=new Array(4102,4100,"物流经理","Logistics Manager",0)
sort[57]=new Array(3902,3900,"船体结构工程师","Hull Structural Engineer",0)
sort[58]=new Array(3802,3800,"采矿/选矿工程师","Mining / mineral processing engineer",0)
sort[59]=new Array(3702,3700,"LED显示屏","LED display",0)
sort[60]=new Array(3602,3600,"彩妆培训师","Makeup Trainer",0)
sort[61]=new Array(3502,3500,"大学教授","Professor",0)
sort[62]=new Array(3402,3400,"服装/纺织设计","Fashion/Textiles Designer",0)
sort[63]=new Array(2902,2900,"化学分析测试员","Chemical Analyst",0)
sort[64]=new Array(2702,2700,"物业管理经理/主管","Property Management Manager/Supervisor",0)
sort[65]=new Array(2802,2800,"消化内科","digestion medicine",0)
sort[66]=new Array(2602,2600,"房地产项目/开发/策划主管/专员","Real Estate Project/Development/Planning Superviso",0)
sort[67]=new Array(2202,2200,"贸易/进出口专员/助理","Trading/Imports",0)
sort[68]=new Array(2502,2500,"建筑工程师","Architect",0)
sort[69]=new Array(2402,2400,"高级技工/操作员","Senior Technician / Operator",0)
sort[70]=new Array(2302,2300,"技术研发工程师","Technical Design Engineer",0)
sort[71]=new Array(2102,2100,"证券分析师","Securities Analyst",0)
sort[72]=new Array(2002,2000,"个人业务部门经理/主管","Personal Banking Manager/Supervisor",0)
sort[73]=new Array(1902,1900,"有线传输工程师","Wired Transmission Engineer",0)
sort[74]=new Array(1802,1800,"行政经理/主管/办公室主任","Admin Manager/Supervisor/Office Manager",0)
sort[75]=new Array(1702,1700,"总工程师/副总工程师","Chief Engineer",0)
sort[76]=new Array(1602,1600,"财务总监","Finance Controller / Director",0)
sort[77]=new Array(1502,1500,"市场/营销/拓展经理","Marketing / BD Manager",0)
sort[78]=new Array(1100,0,"高级管理","Senior Management",1)
sort[79]=new Array(1402,1400,"客服经理(非技术) "," Customer Service Manager",0)
sort[80]=new Array(1102,1100,"首席运营官COO","Chief Operation Officer (COO)",0)
sort[81]=new Array(1302,1300,"销售经理","Sales Manager",0)
sort[82]=new Array(1201,1200,"人事经理","Human Resources Manager",0)
sort[83]=new Array(1002,1000,"高级技工/操作员","高级软件工程师",0)
sort[84]=new Array(1003,1000,"网页设计/制作/美工","Web Designer/Production/Creative",0)
sort[85]=new Array(1202,1200,"人事主管","Human Resources Supervisor",0)
sort[86]=new Array(1303,1300,"销售主管","Sales Supervisor",0)
sort[87]=new Array(1200,0,"人力资源","Human Resources",1)
sort[88]=new Array(1105,1100,"副总经理/副总裁","Deputy GM/Vice President",0)
sort[89]=new Array(1403,1400,"客服主管(非技术)","Customer Service Supervisor",0)
sort[90]=new Array(1503,1500,"市场/营销/拓展主管","Marketing / BD Supervisor",0)
sort[91]=new Array(1603,1600,"财务经理","Finance Manager",0)
sort[92]=new Array(1703,1700,"质量/安全管理","Quality/Safety Management",0)
sort[93]=new Array(1803,1800,"行政专员/助理","Admin Staff/Assistant",0)
sort[94]=new Array(1903,1900,"无线通信工程师","Wireless Communication Engineer",0)
sort[95]=new Array(2003,2000,"个人业务客户经理","Personal Banking Account Manager",0)
sort[96]=new Array(2103,2100,"股票/期货操盘手","Stocks/Futures Operator",0)
sort[97]=new Array(2303,2300,"产品工艺/制程工程师","Process Engineer",0)
sort[98]=new Array(2403,2400,"电子产品设计","Electronic Product Designer",0)
sort[99]=new Array(2503,2500,"建筑设计师","Architectural Designer",0)
sort[100]=new Array(2203,2200,"国内贸易人员","Domestic Trade Specialist",0)
sort[101]=new Array(2603,2600,"房产项目配套工程师","Conveyance System Engineer",0)
sort[102]=new Array(2803,2800,"妇产科","Obstetrics and Gynecology",0)
sort[103]=new Array(2703,2700,"物业管理专员/助理","Property Management Specialist/Assistant",0)
sort[104]=new Array(2903,2900,"医药技术研发管理人员","Pharmaceutical Technology R",0)
sort[105]=new Array(3403,3400,"面料辅料开发","Fabric/Accessories Development",0)
sort[106]=new Array(3503,3500,"讲师/助教","Lecturer/Teaching Assistant",0)
sort[107]=new Array(3603,3600,"专柜彩妆顾问(BA) ","Beauty Advisor",0)
sort[108]=new Array(3703,3700,"传统照明","Traditional lighting",0)
sort[109]=new Array(3803,3800,"通风/安全工程师","Ventilation / Safety Engineer",0)
sort[110]=new Array(3903,3900,"轮机工程师","Marine Engineers",0)
sort[111]=new Array(4103,4100,"物流主管","Logistics Supervisor",0)
sort[112]=new Array(4003,4000,"地勤人员","Ground Attendant",0)
sort[113]=new Array(3003,3000,"品质管理","Quality Management",0)
sort[114]=new Array(3103,3100,"宴会管理","Banquet Management",0)
sort[115]=new Array(3203,3200,"餐饮/娱乐服务员","Restaurant ",0)
sort[116]=new Array(3303,3300,"配色技术员","Color Matcher (Technician)",0)
sort[117]=new Array(4303,4300,"平面设计师","Graphic Artist/Designer",0)
sort[118]=new Array(4403,4400,"店员/营业员","Store Manager Trainee/Salesperson",0)
sort[119]=new Array(4503,4500,"法务经理","Corporate Counsel/Compliance Officer",0)
sort[120]=new Array(4203,4200,"电气/电器/设备类","Electrical / Electronics / Equipment",0)
sort[121]=new Array(4603,4600,"电焊工/铆焊工","Electric Welding Worker",0)
sort[122]=new Array(5003,5000,"农艺师","Agronomist",0)
sort[123]=new Array(4703,4700,"采购主管","Purchasing Supervisor",0)
sort[124]=new Array(4803,4800,"德语翻译","German Translator",0)
sort[125]=new Array(4903,4900,"环保检测","Environmental Inspector",0)
sort[126]=new Array(4904,4900,"水质检测员","Water Quality Inspector",0)
sort[127]=new Array(4804,4800,"法语翻译","French Translator",0)
sort[128]=new Array(4704,4700,"采购员","Purchasing Specialist/Staff",0)
sort[129]=new Array(5004,5000,"畜牧师","Animal Husbandry",0)
sort[130]=new Array(4604,4600,"车工/磨工/铣工/冲压工/锣工","Latheman/Grinder/Miller/Puncher/Turner",0)
sort[131]=new Array(4204,4200,"电力环保","Environmental Power",0)
sort[132]=new Array(4504,4500,"法务主管/专员","Legal Supervisor/Specialist",0)
sort[133]=new Array(4404,4400,"安防主管","Security Technical Service Executive",0)
sort[134]=new Array(4304,4300,"绘画","Graphic Illustrator",0)
sort[135]=new Array(3304,3300,"无机化工","Inorganic Chemicals",0)
sort[136]=new Array(3204,3200,"传菜主管/传菜员","Food Server",0)
sort[137]=new Array(3104,3100,"大堂经理","Hall Manager",0)
sort[138]=new Array(3004,3000,"高级印刷技术人员","Senior printing technology staff",0)
sort[139]=new Array(4004,4000,"列车/地铁车长","Train/Subway Conductor",0)
sort[140]=new Array(4104,4100,"物流专员/助理","Logistics Specialist/Assistant",0)
sort[141]=new Array(3904,3900,"焊接工程师","Welding Engineer",0)
sort[142]=new Array(3804,3800,"矿物分析/化验","Mineral analysis / testing",0)
sort[143]=new Array(3704,3700,"灯饰配件","Lighting Accessories",0)
sort[144]=new Array(3604,3600,"美容助理/见席美容师","Beautician Assistant",0)
sort[145]=new Array(3504,3500,"中学教师","High School Teacher",0)
sort[146]=new Array(3404,3400,"面料辅料采购","Fabric/Accessories Purchasing",0)
sort[147]=new Array(2904,2900,"医药技术研发人员","Pharmaceutical Technology R",0)
sort[148]=new Array(2704,2700,"物业招商/租赁/租售","Property Lease/Rent",0)
sort[149]=new Array(2804,2800,"内分泌及免疫","Endocrine and immune Division",0)
sort[150]=new Array(2604,2600,"房地产项目招投标","Real Estate Tender /Bidding",0)
sort[151]=new Array(2204,2200,"业务跟单经理","Merchandising Manager",0)
sort[152]=new Array(2504,2500,"市政工程师","Municipal Project Engineer",0)
sort[153]=new Array(2404,2400,"研发/技术类","R ",0)
sort[154]=new Array(2304,2300,"产品规划工程师","Product Planing Engineer",0)
sort[155]=new Array(2104,2100,"金融/经济研究员","Financial Analyst/Economist",0)
sort[156]=new Array(2004,2000,"公司业务部门经理/主管","Corporate Banking Manager",0)
sort[157]=new Array(1904,1900,"电信交换工程师","Telecommunication Exchange Engineer",0)
sort[158]=new Array(1804,1800,"经理助理/秘书","Executive Assistant/Secretary",0)
sort[159]=new Array(1704,1700,"项目总监","Project Director",0)
sort[160]=new Array(1604,1600,"财务顾问","Finance Consultant",0)
sort[161]=new Array(1504,1500,"市场/营销/拓展专员","Marketing / BD Executive/Communication",0)
sort[162]=new Array(1300,0,"销售类","Sales",1)
sort[163]=new Array(1404,1400,"客服专员/助理(非技术)","Customer Service Executive/Assistant",0)
sort[164]=new Array(1106,1100,"合伙人","Partner",0)
sort[165]=new Array(1304,1300,"业务拓展主管/经理","Business Development Supervisor/Manager",0)
sort[166]=new Array(1203,1200,"人事专员","Human Resources Specialist",0)
sort[167]=new Array(1004,1000,"互联网软件开发工程师","Internet/E-Commerce Software Engineer",0)
sort[168]=new Array(1005,1000,"技术支持/维护工程师","Technical Support/Maintenance Engineer",0)
sort[169]=new Array(1204,1200,"人事助理","Human Resources Assistant",0)
sort[170]=new Array(1305,1300,"渠道/分销总监","Channel/Distribution Director",0)
sort[171]=new Array(1103,1100,"总监/部门经理","Director/Department Manager",0)
sort[172]=new Array(1405,1400,"客户关系经理/主管","Customer Relations Management/ Supervisor",0)
sort[173]=new Array(1400,0,"客服及技术支持","Customer Service ",1)
sort[174]=new Array(1505,1500,"市场助理","Marketing Assistant / Trainee",0)
sort[175]=new Array(1605,1600,"财务主管/总帐主管","Finance Supervisor",0)
sort[176]=new Array(1705,1700,"项目经理/主管","Project Manager/Supervisor",0)
sort[177]=new Array(1805,1800,"前台接待/总机/接待生","Receptionist",0)
sort[178]=new Array(1905,1900,"数据通信工程师","Data Communication Engineer",0)
sort[179]=new Array(2005,2000,"公司业务客户经理","Corporate Banking Account Manager",0)
sort[180]=new Array(2105,2100,"投资/基金项目经理","Investment Manager/Fund Manager",0)
sort[181]=new Array(2305,2300,"实验室负责人/工程师","Lab Manager/Engineer",0)
sort[182]=new Array(2405,2400,"发动机及附件设计","Engine And Accessories Designer",0)
sort[183]=new Array(2505,2500,"结构/土木/土建工程师","Structural Engineer",0)
sort[184]=new Array(2205,2200,"高级业务跟单","Senior Merchandiser",0)
sort[185]=new Array(2605,2600,"房地产评估","Real Estate Appraisal",0)
sort[186]=new Array(2805,2800,"神经科","Neurology",0)
sort[187]=new Array(2705,2700,"物业设施管理人员","Property Establishment Management",0)
sort[188]=new Array(2905,2900,"临床研究员","Clinical Researcher",0)
sort[189]=new Array(3405,3400,"服装/纺织/皮革跟单","Apparels/Textiles/Leather Goods Merchandiser",0)
sort[190]=new Array(3505,3500,"小学教师","Grade School Teacher",0)
sort[191]=new Array(3605,3600,"瘦身顾问","Slimming/Weight Loss Conunselor",0)
sort[192]=new Array(3705,3700,"照明工程","Lighting Project",0)
sort[193]=new Array(3805,3800,"冶金工程师","Metallurgical Engineer",0)
sort[194]=new Array(3905,3900,"机械工程师","Mechanical Engineer",0)
sort[195]=new Array(4105,4100,"供应链总监","Supply Chain Director",0)
sort[196]=new Array(4005,4000,"列车/地铁司机","Train/Subway Driver",0)
sort[197]=new Array(3005,3000,"印刷操作工/普工","Print Operator / general workers",0)
sort[198]=new Array(3105,3100,"宾客服务经理","Guest Service Manager",0)
sort[199]=new Array(3205,3200,"礼仪/迎宾","Reception",0)
sort[200]=new Array(3305,3300,"有机化工","Organic Chemical",0)
sort[201]=new Array(4305,4300,"动画/3D设计","Animation/3D Designer",0)
sort[202]=new Array(4405,4400,"防损员/内保","Loss Prevention staff",0)
sort[203]=new Array(4505,4500,"法务助理","Legal Assistant",0)
sort[204]=new Array(4205,4200,"电力监理","Power Supervision",0)
sort[205]=new Array(4905,4900,"污水处理工程师","Sewage Treatment Engineer",0)
sort[206]=new Array(5005,5000,"饲养员","Animal Care Technician",0)
sort[207]=new Array(4605,4600,"切割技工","Cutting Technician",0)
sort[208]=new Array(4705,4700,"采购助理","Purchasing Assistant",0)
sort[209]=new Array(4805,4800,"俄语翻译","Russian Translator",0)
sort[210]=new Array(4806,4800,"意大利语翻译","Italian Translator",0)
sort[211]=new Array(4706,4700,"买手","Buyer",0)
sort[212]=new Array(4606,4600,"模具工","Mould Worker",0)
sort[213]=new Array(5006,5000,"动物营养/饲料研发","Animal Food R",0)
sort[214]=new Array(4906,4900,"固废工程师","Waste Treatment Engineer",0)
sort[215]=new Array(4206,4200,"核电","Nuclear power",0)
sort[216]=new Array(4506,4500,"合规经理","Compliance Manager",0)
sort[217]=new Array(4406,4400,"收银主管/收银员","Cashier",0)
sort[218]=new Array(4306,4300,"原画师","Original Artist",0)
sort[219]=new Array(3306,3300,"生物/医学/中间体区","Biology / Medicine / intermediate area",0)
sort[220]=new Array(3206,3200,"司仪","Event Host",0)
sort[221]=new Array(3106,3100,"楼面经理","Floor Manager",0)
sort[222]=new Array(3006,3000,"版房","Version of the Housing",0)
sort[223]=new Array(4006,4000,"船长/副船长","Fleet Captain/ vice Captain",0)
sort[224]=new Array(4106,4100,"供应链经理","Supply Chain Manager",0)
sort[225]=new Array(3906,3900,"船舶设计类","Ship design",0)
sort[226]=new Array(3806,3800,"矿建/施工/工程","Mine Construction / Construction / Engineering",0)
sort[227]=new Array(3706,3700,"照明设计","Lighting Design",0)
sort[228]=new Array(3606,3600,"发型师","Hair Stylist",0)
sort[229]=new Array(3506,3500,"幼教","Preschool Teacher ",0)
sort[230]=new Array(3406,3400,"质量管理/验货员(QA/QC) ","Quality Management QA/QC",0)
sort[231]=new Array(2906,2900,"临床协调员","Clinical Coodinator",0)
sort[232]=new Array(2706,2700,"物业机电工程师","Property Mechanical Engineer",0)
sort[233]=new Array(2806,2800,"外科","Surgeon",0)
sort[234]=new Array(2606,2600,"房地产销售经理/主管","Real Estate Sales Manager/Supervisor",0)
sort[235]=new Array(2206,2200,"业务跟单","Merchandiser",0)
sort[236]=new Array(2506,2500,"公路/桥梁/港口/隧道工程","Road/Bridge/Port/Tunnel Project Engineer",0)
sort[237]=new Array(2406,2400,"内外饰设计工程师","Interior and exterior design engineers",0)
sort[238]=new Array(2306,2300,"工程/设备经理","Engineering/Facility Manager",0)
sort[239]=new Array(2106,2100,"投资/理财顾问","Investment/Financial Management Advisor",0)
sort[240]=new Array(1600,0,"财务/审计/税务","Finance/Accounting/Audit/Tax",1)
sort[241]=new Array(2006,2000,"综合业务经理/主管","Integrated Service Manager/Supervisor",0)
sort[242]=new Array(1906,1900,"移动通信工程师","Mobile Communication Engineer",0)
sort[243]=new Array(1806,1800,"后勤","Office Support",0)
sort[244]=new Array(1706,1700,"项目工程师","Project Engineer",0)
sort[245]=new Array(1606,1600,"会计经理/会计主管","Accounting Manager/Supervisor",0)
sort[246]=new Array(1500,0,"市场/营销","Marketing",1)
sort[247]=new Array(1506,1500,"市场分析/调研人员","Market Analyst/ Research Analyst",0)
sort[248]=new Array(1406,1400,"投诉专员","Complaints Specialist",0)
sort[249]=new Array(1104,1100,"办事处首席代表","Chief Representative",0)
sort[250]=new Array(1306,1300,"渠道/分销经理","Channel/Distribution Manager",0)
sort[251]=new Array(1205,1200,"招聘经理/主管","Recruiting Manager/Supervisor",0)
sort[252]=new Array(1006,1000,"硬件工程师","Hardware Engineer",0)
sort[253]=new Array(1007,1000,"网站编辑","Web Editor",0)
sort[254]=new Array(1206,1200,"招聘专员/助理","Recruiting Specialist/Assistant",0)
sort[255]=new Array(1307,1300,"渠道/分销主管","Channel/Distribution Supervisor",0)
sort[256]=new Array(1407,1400,"售前/售后技术支持经理","Technical Support Manager",0)
sort[257]=new Array(1507,1500,"产品/品牌经理","Product/Brand Manager",0)
sort[258]=new Array(1207,1200,"人事总监","Human Resources Director",0)
sort[259]=new Array(1607,1600,"会计","Accountant / Accounting Trainee",0)
sort[260]=new Array(1707,1700,"营运经理","Operations Manager",0)
sort[261]=new Array(1807,1800,"图书管理员/资料管理员","Librarian / Information/Data Management Specialist",0)
sort[262]=new Array(1907,1900,"电信网络工程师","Telecommunication Network Engineer",0)
sort[263]=new Array(2007,2000,"综合业务专员","Integrated Service Officer",0)
sort[264]=new Array(1700,0,"生产/营运","Manufacturing/Operation",1)
sort[265]=new Array(2107,2100,"投资银行业务","Investment Banking Specialist",0)
sort[266]=new Array(2307,2300,"气动/液压工程师","Pneumatic / Hydraulic Engineer",0)
sort[267]=new Array(2407,2400,"产品匹配设计师","Products matching designer",0)
sort[268]=new Array(2507,2500,"岩土工程","Geotechnical Engineer",0)
sort[269]=new Array(2207,2200,"助理业务跟单","Assistant Merchandiser",0)
sort[270]=new Array(2607,2600,"房地产中介/交易","Real Estate Agent/Broker",0)
sort[271]=new Array(2807,2800,"口腔科","Dentists",0)
sort[272]=new Array(2707,2700,"物业维修人员","Property Maintainence Staff",0)
sort[273]=new Array(2907,2900,"临床数据分析员","Clinical Data Analyst",0)
sort[274]=new Array(3407,3400,"板房/楦头/底格出格师","Shoe Tree Design",0)
sort[275]=new Array(3507,3500,"院校教务管理人员","Educational Facility Management",0)
sort[276]=new Array(3607,3600,"发型助理/学徒","Hair Stylist Assistant",0)
sort[277]=new Array(3807,3800,"机械/机电设备/维修","mechanical/electromechanical equipment maintenance",0)
sort[278]=new Array(3907,3900,"钢结构工程师","Steel Engineers",0)
sort[279]=new Array(4107,4100,"供应链主管/专员","Supply Chain Supervisor/Specialist",0)
sort[280]=new Array(4007,4000,"船员","Sailor",0)
sort[281]=new Array(3007,3000,"装订机械操作人员","Binding machine operators",0)
sort[282]=new Array(3107,3100,"前厅接待","Reception ",0)
sort[283]=new Array(3207,3200,"行政主厨/厨师长","Executive Chef",0)
sort[284]=new Array(3208,3200,"厨师/面点师","Chef/Cook",0)
sort[285]=new Array(3307,3300,"精细化工","Fine Chemicals",0)
sort[286]=new Array(4307,4300,"展览/展示/店面设计","Exhibition/Display/Storefront Designer",0)
sort[287]=new Array(4407,4400,"理货员/陈列员/收货员","Inventory Manager/Displayer/Receiver",0)
sort[288]=new Array(4507,4500,"合规主管/专员","Compliance Supervisor/Specialist",0)
sort[289]=new Array(4207,4200,"电源研发","Power R ",0)
sort[290]=new Array(4907,4900,"节能工程师","Energy Engineer",0)
sort[291]=new Array(4607,4600,"电工","Electrician",0)
sort[292]=new Array(4707,4700,"供应商开发","Supplier Development",0)
sort[293]=new Array(4807,4800,"西班牙语翻译","Spanish Translator",0)
sort[294]=new Array(4808,4800,"葡萄牙语翻译","Portuguese Translator",0)
sort[295]=new Array(4608,4600,"叉车工","Forklift Worker",0)
sort[296]=new Array(4208,4200,"电源生产","Power Production",0)
sort[297]=new Array(4408,4400,"导购员","Sales",0)
sort[298]=new Array(4308,4300,"多媒体设计","Multimedia Designer",0)
sort[299]=new Array(3308,3300,"分析化工","Analysis of chemical",0)
sort[300]=new Array(3108,3100,"预定部主管","Reservation Supervisor",0)
sort[301]=new Array(3008,3000,"烫金/模切","Stamping / Die Cutting",0)
sort[302]=new Array(4008,4000,"乘务员","Attendant",0)
sort[303]=new Array(4108,4100,"物料经理","Materials Manager",0)
sort[304]=new Array(3908,3900,"船舶电气设备工程师","Marine Electrical Equipment Engineer",0)
sort[305]=new Array(3608,3600,"美甲师","Nail Specialist",0)
sort[306]=new Array(3508,3500,"兼职教师","Part-time Teacher",0)
sort[307]=new Array(3408,3400,"打样/制版","Sample Production",0)
sort[308]=new Array(2908,2900,"药品注册","Pharmaceuticals Register Specialist",0)
sort[309]=new Array(2808,2800,"放射科","Radiology",0)
sort[310]=new Array(2608,2600,"房地产销售人员","Real Estate Sales",0)
sort[311]=new Array(2508,2500,"楼宇自动化","Building Automation",0)
sort[312]=new Array(2408,2400,"电装设计开发","Electric drive design and development",0)
sort[313]=new Array(2308,2300,"绘图/3维/3D/2D","Drafter/3D/2D",0)
sort[314]=new Array(2108,2100,"融资经理/融资主管","Treasury Manager/Supervisor",0)
sort[315]=new Array(1800,0,"行政/后勤","Admin./Support Services",1)
sort[316]=new Array(2008,2000,"资产评估/分析","Assets Valuation/Analyst",0)
sort[317]=new Array(1908,1900,"通信电源工程师","Communication Power Supply Engineer",0)
sort[318]=new Array(1808,1800,"电脑操作员/打字员","Computer Operator/Typist",0)
sort[319]=new Array(1708,1700,"营运主管","Operations Supervisor",0)
sort[320]=new Array(1608,1600,"出纳员","Cashier",0)
sort[321]=new Array(1508,1500,"产品/品牌主管","Product/Brand Supervisor",0)
sort[322]=new Array(1408,1400,"售前/售后技术支持主管","Technical Support Supervisor",0)
sort[323]=new Array(1308,1300,"大客户经理","Key Account Manager",0)
sort[324]=new Array(1208,1200,"薪资福利经理/主管","Compensation ",0)
sort[325]=new Array(1008,1000,"项目经理","Project Manager",0)
sort[326]=new Array(1009,1000,"网站营运专员","Web Operations Specialist",0)
sort[327]=new Array(1409,1400,"售前/售后技术支持工程师","Technical Support Engineer",0)
sort[328]=new Array(1509,1500,"产品/品牌专员","Product/Brand Executive",0)
sort[329]=new Array(1609,1600,"财务/会计助理","Finance/Accounting Assistant",0)
sort[330]=new Array(1209,1200,"薪资福利专员/助理","Compensation ",0)
sort[331]=new Array(1309,1300,"客户经理/主管","Sales Account Manager/Supervisor",0)
sort[332]=new Array(1715,1700,"生产计划/物料管理(PMC) ","Planner/PMC",0)
sort[333]=new Array(1909,1900,"增值产品开发工程师","Value-Added Product Development Engineer",0)
sort[334]=new Array(2009,2000,"风险控制","Risk Management",0)
sort[335]=new Array(1900,0,"通信技术开发及应用","Communication Technology Development and Applicati",1)
sort[336]=new Array(2109,2100,"融资专员","Treasury Specialist",0)
sort[337]=new Array(2309,2300,"模具设计/开发","Mold Design / Development Engineer",0)
sort[338]=new Array(2409,2400,"质量工程师","Quality Engineer",0)
sort[339]=new Array(2509,2500,"建筑机电工程师","Building Electrical Engineer",0)
sort[340]=new Array(2809,2800,"皮肤科","Dermatology",0)
sort[341]=new Array(3409,3400,"电脑放码员","Grading",0)
sort[342]=new Array(3509,3500,"家教","Tutor",0)
sort[343]=new Array(3609,3600,"按摩/足疗","Spa/Massage/Foot Care",0)
sort[344]=new Array(3909,3900,"涂装工程师","Coating Engineer",0)
sort[345]=new Array(4109,4100,"物料主管/专员","Materials Supervisor/Specialist",0)
sort[346]=new Array(4009,4000,"司机","Chauffeur/Driver",0)
sort[347]=new Array(2909,2900,"药品生产/质量管理","Pharmaceutical Manufacturing/Quality Management",0)
sort[348]=new Array(3009,3000,"文字录入/排版","Text Entry/Layout Clerk",0)
sort[349]=new Array(3109,3100,"预定员","Reservation Staff",0)
sort[350]=new Array(3309,3300,"高分子化工/化纤/新材料","Polymer chemical / synthetic / new materials",0)
sort[351]=new Array(3209,3200,"调酒师/吧台员","Bartender",0)
sort[352]=new Array(4309,4300,"包装设计","Package Designer",0)
sort[353]=new Array(4409,4400,"西点师/面包糕点加工","Pastry/Bakery Assistant",0)
sort[354]=new Array(4509,4500,"知识产权/专利顾问/专员","Intellectual Property/Patent Advisor/Specialist",0)
sort[355]=new Array(4209,4200,"电源硬件工程师","Power Hardware Engineer",0)
sort[356]=new Array(4609,4600,"空调工/电梯工/锅炉工","Air-Condition Worker/Lift Worker/Steam Worker",0)
sort[357]=new Array(4809,4800,"阿拉伯语翻译","Arabic Translator",0)
sort[358]=new Array(4810,4800,"韩语/朝鲜语翻译","Korean Translator",0)
sort[359]=new Array(4610,4600,"水工/木工/漆工","Plumber/Carpenter/Painter",0)
sort[360]=new Array(4210,4200,"电源软件工程师","电源软件工程师",0)
sort[361]=new Array(4410,4400,"生鲜食品加工/处理","Raw Food Assistant",0)
sort[362]=new Array(4310,4300,"工业/产品设计","Industrial Designer",0)
sort[363]=new Array(3210,3200,"茶艺师","Tea Specialist",0)
sort[364]=new Array(3310,3300,"玻璃/硅酸盐工业","Glass / Ceramics Industry",0)
sort[365]=new Array(3110,3100,"客房服务员/楼面服务员","Room Service",0)
sort[366]=new Array(3010,3000,"防伪技术/设计/制作","Anti-counterfeiting technology / design / producti",0)
sort[367]=new Array(2910,2900,"药品市场推广经理","Pharmaceutical Marketing Manager",0)
sort[368]=new Array(4110,4100,"仓库经理/主管","Warehouse Manager",0)
sort[369]=new Array(3610,3600,"健身顾问/教练","Fitness Trainer",0)
sort[370]=new Array(3510,3500,"职业技术教师","Vocational Instructor",0)
sort[371]=new Array(3410,3400,"纸样师/车板工","Paper Sample",0)
sort[372]=new Array(2810,2800,"血液内科","Hematology",0)
sort[373]=new Array(2510,2500,"安防工程师","Defence",0)
sort[374]=new Array(2410,2400,"安全工程师","Safety Performance Engineer",0)
sort[375]=new Array(2310,2300,"精度机械/仪器仪表","Precision machinery / instruments",0)
sort[376]=new Array(2110,2100,"拍卖师","Auction",0)
sort[377]=new Array(2000,0,"银行","Banking",1)
sort[378]=new Array(2010,2000,"信贷管理","Loan/Credit Officer",0)
sort[379]=new Array(1910,1900,"手机软件开发工程师","Mobile Software Development Engineer",0)
sort[380]=new Array(1710,1700,"生产主管/督导/领班/组长","Production Supervisor/Team Leader",0)
sort[381]=new Array(1310,1300,"区域销售总监","Regional Sales Director",0)
sort[382]=new Array(1210,1200,"绩效考核经理/主管","Performance Assessment Manager/Supervisor",0)
sort[383]=new Array(1610,1600,"会计文员","Accounting Clerk",0)
sort[384]=new Array(1510,1500,"市场通路经理/主管","Trade Marketing Manager/Supervisor",0)
sort[385]=new Array(1410,1400,"咨询热线/呼叫中心服务人员","Customer Hot Line/Call Center Staff",0)
sort[386]=new Array(1010,1000,"多媒体/游戏开发工程师","Multimedia/Game Development Engineer",0)
sort[387]=new Array(1011,1000,"系统管理员/网络管理员","System Manager/Webmaster",0)
sort[388]=new Array(1411,1400,"VIP专员","VIP Member Specialist",0)
sort[389]=new Array(1511,1500,"市场通路专员","Trade Marketing Specialist",0)
sort[390]=new Array(1611,1600,"固定资产会计","Fixed Asset Accounting",0)
sort[391]=new Array(1311,1300,"区域销售经理","Regional Sales Manager",0)
sort[392]=new Array(1711,1700,"化验员","Clerk",0)
sort[393]=new Array(1911,1900,"手机应用开发工程师","Mobile Application Development Engineer",0)
sort[394]=new Array(2011,2000,"信审核查","Credit Review",0)
sort[395]=new Array(2100,0,"金融/证券/期货/投资","Finance/Securities/Commodities/Investments",1)
sort[396]=new Array(2311,2300,"工程/设备主管","Engineering/Facility Supervisor",0)
sort[397]=new Array(2411,2400,"焊接工程师","Welding Engineer",0)
sort[398]=new Array(2511,2500,"给排水/暖通工程","Drainage/HVAC Project Engineer",0)
sort[399]=new Array(2811,2800,"泌尿外科","urinary surgery",0)
sort[400]=new Array(3411,3400,"裁床","Cut Bed",0)
sort[401]=new Array(3511,3500,"音乐/艺术类老师","Music/art teacher",0)
sort[402]=new Array(3611,3600,"体育运动教练","Coach",0)
sort[403]=new Array(4111,4100,"仓库管理员","Warehouse Specialist",0)
sort[404]=new Array(2911,2900,"药品市场推广主管/专员","Pharmaceutical Marketing Supervisor/Specialist",0)
sort[405]=new Array(3011,3000,"图文制作设计","Graphic Production Designer",0)
sort[406]=new Array(3111,3100,"机场代表","Hotel Airport Representatives",0)
sort[407]=new Array(3311,3300,"日用化工","Household chemicals",0)
sort[408]=new Array(4311,4300,"工艺品/珠宝设计鉴定","Artwork/Jewelry Design and Appraiser",0)
sort[409]=new Array(4411,4400,"熟食加工","Cooked Food Assistant",0)
sort[410]=new Array(4211,4200,"其他","Others",0)
sort[411]=new Array(4611,4600,"普工/操作工","General Worker",0)
sort[412]=new Array(4811,4800,"泰语翻译","Thai Translator",0)
sort[413]=new Array(4912,4800,"中国方言翻译","Chinese Dialect Translator",0)
sort[414]=new Array(4612,4600,"裁缝印纺熨烫","Tailor",0)
sort[415]=new Array(4412,4400,"兼职店员","Part-time Salesperson",0)
sort[416]=new Array(4312,4300,"家具/家居用品设计","Furniture/Household Product Designer",0)
sort[417]=new Array(3312,3300,"环保技术/水处理","Environmental Technology / Water Treatment",0)
sort[418]=new Array(3112,3100,"行李员","luggage clerk",0)
sort[419]=new Array(3012,3000,"产品包装设计","Product packaging designer",0)
sort[420]=new Array(2912,2900,"医药招商","Pharmaceutical Business Development",0)
sort[421]=new Array(4112,4100,"运输经理/主管","Distribution Manager/Supervisor",0)
sort[422]=new Array(3612,3600,"救生员","Lifeguard",0)
sort[423]=new Array(3412,3400,"其他","Others",0)
sort[424]=new Array(2812,2800,"呼吸内科","Respiratory Medicine",0)
sort[425]=new Array(2512,2500,"幕墙工程师","Curtain Wall Engineer",0)
sort[426]=new Array(2412,2400,"涂装工程师","Coating Engineer",0)
sort[427]=new Array(2312,2300,"工程/设备工程师","Engineering/Facility Engineer",0)
sort[428]=new Array(2200,0,"贸易/进出口","Trading/Import ",1)
sort[429]=new Array(2012,2000,"进出口/信用证结算","Trading / LC Officer",0)
sort[430]=new Array(1712,1700,"生产总监","Production Director",0)
sort[431]=new Array(1312,1300,"团购经理/主管","Group Purchase Manager/Supervisor",0)
sort[432]=new Array(1512,1500,"市场企划经理/主管","Marketing Planning Manager/Supervisor",0)
sort[433]=new Array(1212,1200,"培训经理/主管","Training Manager/Supervisor",0)
sort[434]=new Array(1612,1600,"财务分析经理/主管","Financial Analysis Manager/Supervisor",0)
sort[435]=new Array(1012,1000,"SEO搜索引擎优化","SEO Specialist",0)
sort[436]=new Array(1213,1200,"培训专员/助理/培训师","Training Specialist/Assistant/Trainer",0)
sort[437]=new Array(1013,1000,"软件测试","Software Testing QA",0)
sort[438]=new Array(1613,1600,"财务分析员","Financial Analyst",0)
sort[439]=new Array(1113,1100,"培训专员/助理/培训师","Training Specialist/Assistant/Trainer",0)
sort[440]=new Array(1713,1700,"生产经理/车间主任","Production Manager/Workshop Supervisor",0)
sort[441]=new Array(1513,1500,"市场企划专员","Marketing Planning Executive",0)
sort[442]=new Array(2013,2000,"外汇交易","Foreign Exchange",0)
sort[443]=new Array(2313,2300,"工程/机械绘图员","Project Drafting Specialist/Mechanical Drawing",0)
sort[444]=new Array(2413,2400,"总装工程师","Assembly engineers",0)
sort[445]=new Array(2513,2500,"规划与设计","Design/Planning",0)
sort[446]=new Array(2300,0,"机械/模具/工程/能源","Machinery/Mould/ Engineering/Energy",1)
sort[447]=new Array(2813,2800,"精神科","Psychiatric",0)
sort[448]=new Array(3613,3600,"瑜伽/舞蹈老师","Yoga/Dance Instructor",0)
sort[449]=new Array(4113,4100,"项目经理/主管","Project Manager/Supervisor",0)
sort[450]=new Array(2913,2900,"政府事务管理","Government Affairs",0)
sort[451]=new Array(3013,3000,"物料管理","Materials Management",0)
sort[452]=new Array(3113,3100,"管家部经理/主管","Housekeeping Manager",0)
sort[453]=new Array(3313,3300,"电镀化工","Electroplating Chemicals",0)
sort[454]=new Array(3314,3300,"造纸/废品处理","Electroplating Chemicals",0)
sort[455]=new Array(3114,3100,"清洁服务人员","Housekeeping Staff",0)
sort[456]=new Array(3014,3000,"化验/检验员","Tester / inspector",0)
sort[457]=new Array(2914,2900,"招投标管理","Tendering Coordinator",0)
sort[458]=new Array(4114,4100,"货运代理","Traffic Agent",0)
sort[459]=new Array(3614,3600,"宠物护理/美容","Pet Care",0)
sort[460]=new Array(2814,2800,"肾脏内科","Nephrology",0)
sort[461]=new Array(2400,0,"汽车","Automobile",1)
sort[462]=new Array(2514,2500,"室内外装潢设计","Interial Design/Decorator",0)
sort[463]=new Array(2414,2400,"冲压工程师","Punch Engineer",0)
sort[464]=new Array(2314,2300,"工业工程师","Industrial Engineer",0)
sort[465]=new Array(2014,2000,"清算人员","Settlement Officer",0)
sort[466]=new Array(1514,1500,"促销经理","Promotion Manager",0)
sort[467]=new Array(1714,1700,"生产文员","Clerk",0)
sort[468]=new Array(1214,1200,"企业文化/员工关系/工会管理","Corporate Culture/Employee Labor Union Relations",0)
sort[469]=new Array(1314,1300,"电话销售","Telesales",0)
sort[470]=new Array(1614,1600,"成本经理/成本主管","Cost Accounting Manager/Supervisor",0)
sort[471]=new Array(1615,1600,"成本管理员","Cost Accounting Specialist",0)
sort[472]=new Array(1315,1300,"经销商","Distributor",0)
sort[473]=new Array(1215,1200,"人力资源信息系统专员","HRIS Specialist",0)
sort[474]=new Array(1515,1500,"促销主管/督导","Promotion Supervisor",0)
sort[475]=new Array(1022,1000,"数据库工程师/管理员","Database Engineer/Administrator",0)
sort[476]=new Array(2015,2000,"高级客户经理/客户经理","Senior Relationship Manager/ Relationship Manager",0)
sort[477]=new Array(2315,2300,"材料工程师","Material Engineer",0)
sort[478]=new Array(2415,2400,"机械专业人员","Mechanical Professional",0)
sort[479]=new Array(2515,2500,"园艺/园林/景观设计","Gardenning Designer",0)
sort[480]=new Array(2500,0,"建筑/监理/施工/市政建设","Construction / supervision / construction / munici",1)
sort[481]=new Array(2815,2800,"小儿科","Pediatrician",0)
sort[482]=new Array(4115,4100,"集装箱业务","Container Operator",0)
sort[483]=new Array(2915,2900,"医药销售经理/主管","Pharmaceutical Sales Manager",0)
sort[484]=new Array(3015,3000,"印刷机机长","Printing Machine Operator",0)
sort[485]=new Array(3115,3100,"健身房服务","Fitness Center Service",0)
sort[486]=new Array(3315,3300,"塑胶/注塑","plastic cement/ injection molding",0)
sort[487]=new Array(3316,3300,"农药/化肥","agricultural chemical/ fertilizers",0)
sort[488]=new Array(3116,3100,"旅游产品销售","Tourism Product Sales",0)
sort[489]=new Array(3016,3000,"包装设计师","packaging designer",0)
sort[490]=new Array(2916,2900,"医药销售代表","Pharmaceutical Sales Representative",0)
sort[491]=new Array(4116,4100,"海关事务管理","Customs Affairs Manager",0)
sort[492]=new Array(2600,0,"房地产","Real Estate",1)
sort[493]=new Array(2816,2800,"眼科","Ophthalmology",0)
sort[494]=new Array(2516,2500,"测绘/测量","Mapping/Surveyor",0)
sort[495]=new Array(2416,2400,"设备/模具","Equipment / Mold",0)
sort[496]=new Array(2316,2300,"机械工程师","Mechanical Engineer",0)
sort[497]=new Array(2016,2000,"客户主管/专员","Relationship Supervisor/Executive",0)
sort[498]=new Array(1516,1500,"促销员/导购","Promotion Specialist",0)
sort[499]=new Array(1316,1300,"客户代表","Sales Account Representative",0)
sort[500]=new Array(1616,1600,"资金经理/主管","Treasury Manager/Supervisor",0)
sort[501]=new Array(1617,1600,"资金专员","Treasury Specialist",0)
sort[502]=new Array(1317,1300,"销售代表","Sales Representative / Executive",0)
sort[503]=new Array(1517,1500,"选址拓展/新店开发","Site Development",0)
sort[504]=new Array(1014,1000,"网站策划","Web Produce",0)
sort[505]=new Array(2017,2000,"营业部大堂经理","Branch Lobby Manager",0)
sort[506]=new Array(2317,2300,"结构工程师","Structrual Engineer",0)
sort[507]=new Array(2417,2400,"汽车试验/测试/验车员","Automotive tester",0)
sort[508]=new Array(2517,2500,"建筑制图","CAD Drafter",0)
sort[509]=new Array(2817,2800,"病理科","Pathology",0)
sort[510]=new Array(2700,0,"物业管理 ","Property Management",1)
sort[511]=new Array(4117,4100,"报关员","Customs declaration Specialist",0)
sort[512]=new Array(2917,2900,"医疗设备注册","Medical Equipment Register",0)
sort[513]=new Array(3017,3000,"缓冲包装设计","Cushion Packaging Designer",0)
sort[514]=new Array(3117,3100,"导游/旅行顾问","Tour Guide/Travel Consultant",0)
sort[515]=new Array(3317,3300,"化学工程与工艺","Chemical Engineering and Technology",0)
sort[516]=new Array(3318,3300,"总工程师","Chief Engineer",0)
sort[517]=new Array(3118,3100,"行程管理/操作","Travel Management /Operations",0)
sort[518]=new Array(3018,3000,"包装结构设计","packaging structure designer",0)
sort[519]=new Array(2918,2900,"医疗设备生产/质量管理","Medical Equipment Manufacture/Quality Control",0)
sort[520]=new Array(4118,4100,"单证员","Documentation Specialist",0)
sort[521]=new Array(2800,0,"医疗","Health And Medical Community",1)
sort[522]=new Array(2818 ,2800,"性病科","Venereology",0)
sort[523]=new Array(2518,2500,"开发报建","Programming",0)
sort[524]=new Array(2418,2400,"汽车总布置工程师","Automotive Layout Engineer",0)
sort[525]=new Array(2318,2300,"模具工程师","Tooling Engineer",0)
sort[526]=new Array(2018,2000,"银行柜员","Bank Teller",0)
sort[527]=new Array(1015,1000,"测试工程师","Quality Testing Engineer",0)
sort[528]=new Array(1618,1600,"审计经理/主管","Audit Manager/Supervisor",0)
sort[529]=new Array(1619,1600,"审计专员/助理","Audit Executive/Assistant",0)
sort[530]=new Array(1019,1000,"网络工程师","Network Engineer",0)
sort[531]=new Array(2019,2000,"银行卡、电子银行业务推广","Credit Card/E-banking business Develop",0)
sort[532]=new Array(2319,2300,"机电工程师","Electrical ",0)
sort[533]=new Array(2419,2400,"底盘及传动系统工程师","Chassis and transmission engineers",0)
sort[534]=new Array(2519,2500,"工程造价师/预结算经理","Project Estimator",0)
sort[535]=new Array(2819,2800,"肛肠科","Anorectal",0)
sort[536]=new Array(2900,0,"生物/制药/医疗器械","Biotechnology/Pharmaceuticals/Medical Equipment",1)
sort[537]=new Array(4119,4100,"船务/空运陆运操作","Shipping/air ",0)
sort[538]=new Array(2919,2900,"医疗器械市场推广","Medical Equipment Marketing",0)
sort[539]=new Array(3019,3000,"包装工程师","Packaging Engineer",0)
sort[540]=new Array(3119,3100,"票务/订房服务","Reservation Service",0)
sort[541]=new Array(3319,3300,"品质工程师","Quality Engineer",0)
sort[542]=new Array(3320,3300,"化验/检验员","Tester / inspector",0)
sort[543]=new Array(3000,0,"印刷/包装/造纸","Printing/Packaging/Paper",1)
sort[544]=new Array(3120,3100,"签证专员","Visa Specialist",0)
sort[545]=new Array(3020,3000,"包装工艺师","packaging Technologists",0)
sort[546]=new Array(4120,4100,"快递员","Courier",0)
sort[547]=new Array(2920,2900,"医疗器械销售","Medical Equipment Sales",0)
sort[548]=new Array(2820,2800,"治疗室","Treatment room",0)
sort[549]=new Array(2520,2500,"预结算员","Quantity Surveyor",0)
sort[550]=new Array(2420,2400,"机电一体化工程师","Mechatronics Engineer",0)
sort[551]=new Array(2320,2300,"维修经理/主管","Maintenance Manager/Supervisor",1)
sort[552]=new Array(1020,1000,"系统工程师","System Engineer",0)
sort[553]=new Array(1620,1600,"税务经理/税务主管","Tax Manager/Supervisor",0)
sort[554]=new Array(1021,1000,"网站营运经理/主管","Web Operations Manager/Supervisor",0)
sort[555]=new Array(2321,2300,"维修工程师","Maintenance Engineer",0)
sort[556]=new Array(2421,2400,"汽车改装工程师","Automotive remodel Engineer",0)
sort[557]=new Array(2521,2500,"建筑工程管理/项目经理","Construction Project Management",0)
sort[558]=new Array(2821,2800,"整形/美容","Plastic Surgeon",0)
sort[559]=new Array(2921,2900,"医疗器械维修人员","Medical Equipment Maintenance Engineer",0)
sort[560]=new Array(4121,4100,"调度员","Dispatcher",0)
sort[561]=new Array(3021,3000,"材料工程师","Materials Engineer",0)
sort[562]=new Array(3121,3100,"其他","Others",0)
sort[563]=new Array(3100,0,"酒店/旅游","Hospitality/Tourism",1)
sort[564]=new Array(3200,0,"餐饮/娱乐","Restaurant ",1)
sort[565]=new Array(3022,3000,"造纸工艺工程师","Paper Process Engineer",0)
sort[566]=new Array(4122,4100,"理货员","Warehouse Stock Manager",0)
sort[567]=new Array(2822,2800,"化验/检验","Testing / inspection",0)
sort[568]=new Array(2522,2500,"建筑工程验收","Construction Project Inspector",0)
sort[569]=new Array(2422,2400,"底盘设计工程师","Chassis Design Engineer",0)
sort[570]=new Array(2322,2300,"装配工程师/技师","Packaging",0)
sort[571]=new Array(2323,2300,"铸造/锻造工程师/技师","Casting/Forging Engineer",0)
sort[572]=new Array(2423,2400,"创意设计师","Creative Designer",0)
sort[573]=new Array(2523,2500,"工程监理","Engineering Project Supervisor",0)
sort[574]=new Array(2823,2800,"麻醉科","Anesthesiologist",0)
sort[575]=new Array(3023,3000,"制浆工程师","制浆工程师",0)
sort[576]=new Array(3300,0,"化工","Chemicals",1)
sort[577]=new Array(3024,3000,"造纸机械工程师","Paper Mechanical Engineer",0)
sort[578]=new Array(3400,0,"服装/纺织","Apparel/Textiles",1)
sort[579]=new Array(2824,2800,"骨科","orthopaedics",0)
sort[580]=new Array(2524,2500,"合同管理","Contract Management",0)
sort[581]=new Array(2424,2400,"混合动力控制系统工程师","Hybrid Control Systems Engineer",0)
sort[582]=new Array(2324,2300,"注塑工程师/技师","Injection Engineer",0)
sort[583]=new Array(2325,2300,"焊接工程师/技师","Welding Engineer",0)
sort[584]=new Array(2425,2400,"汽车经纪/二手车估价师","Automotive  Brokers / Second-Hand Car Appraisers",0)
sort[585]=new Array(2525,2500,"安全员","Safety Specialist",0)
sort[586]=new Array(2825,2800,"器官移植","organ transplantation",0)
sort[587]=new Array(3500,0,"教育","Education",1)
sort[588]=new Array(3025,3000,"技工/普工","General Worker",0)
sort[589]=new Array(3600,0,"美容/美发/保健/体育","Beauty/Hair/Health/Sport",1)
sort[590]=new Array(2826,2800,"传染科","department of infectious disease",0)
sort[591]=new Array(2526,2500,"资料员","Data Management Specialist",0)
sort[592]=new Array(2426,2400,"保险理赔","Insurance Claims",0)
sort[593]=new Array(2326,2300,"夹具工程师/技师","Clamp Engineer",0)
sort[594]=new Array(2327,2300,"CAD/CAM/CNC 工程师","CAD/CAM/CNC Engineer",0)
sort[595]=new Array(2427,2400,"配件经理/主管","Accessories Manager / Supervisor",0)
sort[596]=new Array(2527,2500,"施工员","Construction Crew",0)
sort[597]=new Array(2827,2800,"心脑/血管内科","Heart and brain / vascular medicine",0)
sort[598]=new Array(3700,0,"照明","electric-lamp industry",1)
sort[599]=new Array(2828,2800,"耳鼻喉科","E.N.T.department",0)
sort[600]=new Array(3800,0,"矿产/地质勘查/冶金","Mining / Geological Survey / Metallurgy",1)
sort[601]=new Array(2428,2400,"展厅经理/主管","Showroom Manager / Supervisor",0)
sort[602]=new Array(2328,2300,"冲压工程师/技师","Punch Engineer",0)
sort[603]=new Array(2329,2300,"锅炉工程师/技师","Boiler Engineer",0)
sort[604]=new Array(2429,2400,"汽车维修高级技工","Automotive Repair Senior Technician",0)
sort[605]=new Array(2829,2800,"肿瘤","oncology",0)
sort[606]=new Array(3900,0,"造船","Shipbuilding",1)
sort[607]=new Array(4000,0,"交通运输服务","Traffic Service",1)
sort[608]=new Array(2830,2800,"B超医生","B-scan doctor",0)
sort[609]=new Array(2430,2400,"钣金工","Sheet Metal Workers",0)
sort[610]=new Array(2330,2300,"电力工程师/技术员","Electric Power Engineer",0)
sort[611]=new Array(2331,2320,"光源与照明工程","Lighting Engineer",0)
sort[612]=new Array(2431,2400,"喷漆/调漆工","Painter",0)
sort[613]=new Array(2831,2800,"不孕不育","sterility",0)
sort[614]=new Array(4100,0,"物流/仓储","Distribution/ storage",1)
sort[615]=new Array(4200,0,"电力/电源","Utilities/Energy",1)
sort[616]=new Array(2832,2800,"药剂科","Pharmacist",0)
sort[617]=new Array(2432,2400,"轮胎工","Tire Workers",0)
sort[618]=new Array(2332,2300,"汽车/摩托车工程师","Automotive Engineer",0)
sort[619]=new Array(2333,2300,"船舶工程师","Shipping Engineer",0)
sort[620]=new Array(2433,2400,"机电一体化技工","Mechanic Mechatronics",0)
sort[621]=new Array(2833,2800,"介入诊疗","Interventional diagnosis and treatment",0)
sort[622]=new Array(4300,0,"艺术/设计","Artist/Designer",1)
sort[623]=new Array(4400,0,"百货/连锁/零售服务 ","general merchandise/ catenation/ Retail",1)
sort[624]=new Array(2834,2800,"NICP/PICU","NICP/PICU",0)
sort[625]=new Array(2434,2400,"汽车用品/配件","Auto Supplies / Accessories",0)
sort[626]=new Array(2334,2300,"轨道交通工程师/技术员","Railway Engineer / Technician",0)
sort[627]=new Array(2335,2300,"飞机维修机械师","Aviation Maintenance Technician",0)
sort[628]=new Array(2435,2400,"汽车美容","Automotive beautician",0)
sort[629]=new Array(2835,2800,"中医科","Chinese Medicine Practioners",0)
sort[630]=new Array(4500,0,"律师/法务/合规 ","Legal/Compliance",1)
sort[631]=new Array(4600,0,"技工","Technician / Engineer Trainee",1)
sort[632]=new Array(2836,2800,"急诊科","emergency department",0)
sort[633]=new Array(2436,2400,"贴膜技师","Film technician",0)
sort[634]=new Array(2336,2300,"飞行器设计与制造","Aircraft Design ",0)
sort[635]=new Array(2327,2300,"水利/水电工程师","Water Conservancy/Hydroelectricity Engineer",0)
sort[636]=new Array(2837,2800,"输血科","Blood filtering section office",0)
sort[637]=new Array(4700,0,"采购","Purchasing",1)
sort[638]=new Array(2838,2800,"烧伤科","burn department",0)
sort[639]=new Array(2338,2300,"数控编程","NC Programming",0)
sort[640]=new Array(4800,0,"翻译","Translator",1)
sort[641]=new Array(4900,0,"环保/节能","Environmental Protection/ Energy-Conserving",1)
sort[642]=new Array(2339,2300,"矿产勘探/地质勘测工程师","Mineral Exploration / Geological Survey Engineer",0)
sort[643]=new Array(2839,2800,"营养科","Dietitian",0)
sort[644]=new Array(2840,2800,"理疗康复科","Physical Therapist",0)
sort[645]=new Array(5000,0,"农业/养殖","Agriculture / Aquaculture",1)
sort[646]=new Array(2340,2300,"石油天然气技术人员","Oil/Gas Technician",0)
sort[647]=new Array(9999,9900,"其它","Others",0)
sort[648]=new Array(2841,2800,"放疗科","Radiotherapy",0)
sort[649]=new Array(2842,2800,"体检中心MEC","medical examination center",0)
sort[650]=new Array(2843,2800,"临床应用研究","Clinical Laboratory",0)
sort[651]=new Array(2844,2800,"宠物医生","Pet doctor",0)
sort[652]=new Array(1799,1700,"其他","Others",0)
sort[653]=new Array(9900,0,"其它","Others",1)
sort[654]=new Array(1299,1200,"其他","Others",0)
sort[655]=new Array(1699,1600,"其他","Others",0)
sort[656]=new Array(1999,1900,"其他","Others",0)
sort[657]=new Array(1899,1800,"其他","Others",0)
sort[658]=new Array(1016,1000,"其它","Others",0)
sort[659]=new Array(1108,1100,"其他","Others",0)
sort[660]=new Array(1499,1400,"其它","Others",0)
sort[661]=new Array(1599,1500,"其它","Others",0)
sort[662]=new Array(1399,1300,"其他","Others",0)
sort[663]=new Array(1199,1100,"办事处/分公司/分支机构经理","Branch Office Manager",0)
sort[664]=new Array(2199,2100,"其他","Others",0)
sort[665]=new Array(2099,2000,"其他","Others",0)
sort[666]=new Array(2499,2400,"其他","others",0)
sort[667]=new Array(2599,2500,"其他","Others",0)
sort[668]=new Array(2699,2600,"其他","Others",0)
sort[669]=new Array(2299,2200,"其他","Others",0)
sort[670]=new Array(2399,2300,"其他","Others",0)
sort[671]=new Array(2899,2800,"其它","Others",0)
sort[672]=new Array(3599,3500,"其他","Others",0)
sort[673]=new Array(2799,2700,"其他","Others",0)
sort[674]=new Array(3699,3600,"其他","Others",0)
sort[675]=new Array(3999,3900,"其他","Others",0)
sort[676]=new Array(3899,3800,"其他","Others",0)
sort[677]=new Array(2999,2900,"其他","Others",0)
sort[678]=new Array(4099,4000,"其他","Others",0)
sort[679]=new Array(5099,5000,"其他","Others",0)
sort[680]=new Array(4699,4600,"其他","Others",0)
sort[681]=new Array(4999,4900,"其它","Others",0)
sort[682]=new Array(4199,4100,"其他","Others",0)
sort[683]=new Array(4599,4500,"其他","Others",0)
sort[684]=new Array(4399,4300,"其他","Others",0)
sort[685]=new Array(4499,4400,"其他","Others",0)
sort[686]=new Array(3299,3200,"其他","Others",0)
sort[687]=new Array(3399,3300,"其他","Others",0)
sort[688]=new Array(3099,3000,"其它","Others",0)
sort[689]=new Array(4899,4800,"其他语种翻译","Other Language Translator",0)
sort[690]=new Array(4799,4700,"其他","Others",0)


/*
**	初始化类别
**	initObj:初始化对象
*/
function initsort(initObj){
	opt=document.createElement("OPTION");
	initObj.length=1;
	//sortCount ：类别个数
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[1],10);	
		if(subStrFirst==0){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2];
			initObj.add(opt);
		}
	}
}

/*
**	初始化子类别
**	initObj:初始化对象
*/
function initSonSort(initObj,supCode){
	opt=document.createElement("OPTION");
	initObj.length=0;
	//sortCount ：类别个数
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		if(subArray[0]==supCode){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2]+'-不限';
			initObj.add(opt);
		}
	}
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[1],10);	
		if(subStrFirst !=0 && subStrFirst==supCode){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[2];
			initObj.add(opt);
		}
	}
}
/*
**	初始化类别(English)
**	initObj:初始化对象
*/
function initsortEn(initObj){
	opt=document.createElement("OPTION");
	initObj.length=1;
	//sortCount ：类别个数
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[1],10);	
		if(subStrFirst==0){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[3];
			initObj.add(opt);
		}
	}
}

/*
**	初始化子类别(English)
**	initObj:初始化对象
*/
function initSonSortEn(initObj,supCode){
	opt=document.createElement("OPTION");
	initObj.length=0;
	//sortCount ：类别个数
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[1],10);	
		if(subArray[0]==supCode){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[3]+'-UnRestrict';
			initObj.add(opt);
		}
		if(subStrFirst !=0 && subStrFirst==supCode){
			opt=document.createElement("OPTION");
			opt.value=subArray[0];
			opt.text=subArray[3];
			initObj.add(opt);
		}
	}
}


/*
**	判断是否存在子类别
*/
function isSupCode(sortId){
	var isSupCode="";
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		var subStrFirst=parseInt(subArray[0],10);
		if(subStrFirst == sortId){
			isSupCode=subArray[3];
			break;
		}
	}
	return isSupCode;
}


/*
**	根据给出的类别编码
**	查找类别名称
*/
function getSortName(sortId){
	var name="";
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[0],10);
		//各子对象中的第二个元素
		var subStrSecond=parseInt(subArray[1],10);
		if(subStrFirst==sortId){
			name=subArray[2];
			break;
		}
	}
	return name;
}


/*
**	根据给出的类别编码
**	查找父类名称
*/
function getSupName(sortId){
	var name="";
	var supCode="";
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[0],10);
		//各子对象中的第二个元素
		var subStrSecond=parseInt(subArray[1],10);
		if(subStrFirst==sortId){
			supCode=subStrSecond;
			break;
		}
	}
	for(var j=0;j<sortCount;j++){
		var subArray=sort[j];
		var tempInt=parseInt(subArray[0],10);
		if(supCode==tempInt){
			name=subArray[2];
			break;
		}
	}
	return name;
}
function getparentID(sortId){
	var supCode="";
	for(var i=0;i<sortCount;i++){
		var subArray=sort[i];
		//各子对象中的第一个元素
		var subStrFirst=parseInt(subArray[0],10);
		//各子对象中的第二个元素
		var subStrSecond=parseInt(subArray[1],10);
		if(subStrFirst==sortId){
			supCode=subStrSecond;
			break;
		}
	}
	return supCode;
}


/*删除li节点*/
function   fnDelete(oList,checkCleanHidden,id){
//var   ochild=oList.children[oList.children.length-1];
var   ochild = document.getElementById(id);  
if(ochild) {
   // Clear the hidden..
   if (checkCleanHidden!= null && checkCleanHidden !="") {
       for (var i = 1; i< 4;i++){
           if(document.getElementById("jobFunction"+i).value == id) {
               document.getElementById("jobFunction"+i).value ="";
               document.getElementById("jobF"+i).value = "";
           }
       }
    }
oList.removeChild(ochild);
}
}


/*
**	根据给出的工作编码
**	查找工作名称
*/
function getJobName(jobId){
var name="";
for(var i=0;i<sortCount;i++){
   var subArray=sort[i];
   //各子对象中的第二个元素
   var subStrSecond=parseInt(subArray[0],10);
   if(subStrSecond==jobId){
       name=subArray[2];
       break;
   }
}
return name;
}


/*
**	根据给出的工作编码
**	查找工作名称
*/
function getJobNameEn(jobId){
var name="";
for(var i=0;i<sortCount;i++){
   var subArray=sort[i];
   //各子对象中的第二个元素
   var subStrSecond=parseInt(subArray[0],10);
   if(subStrSecond==jobId){
       name=subArray[3];
       break;
   }
}
return name;
}


