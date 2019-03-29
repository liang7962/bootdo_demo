// $(function () {
//     var myChart = echarts.init(document.getElementById('china-map'));
//
//     var data = [[${data.data}]];
//     console.log(data);
//     var name_title = "示范企业分布"
//     var subname = '——版权所有 请勿复制'
//     var nameColor = "black"
//     var name_fontFamily = '等线'
//     var subname_fontSize = 15
//     var name_fontSize = 18
//     var mapName = 'china'
//     var geoCoordMap = {};
//
//     /*获取地图数据*/
//     myChart.showLoading();
//     var mapFeatures = echarts.getMap(mapName).geoJson.features;
//     myChart.hideLoading();
//     mapFeatures.forEach(function(v) {
//         // 地区名称
//         var name = v.properties.name;
//         // 地区经纬度
//         geoCoordMap[name] = v.properties.cp;
//
//     });
//     var max = 600,
//         min = 9; // todo
//     var maxSize4Pin = 220,
//         minSize4Pin = 25;
//
//     var convertData = function(data) {
//         var res = [];
//         for (var i = 0; i < data.length; i++) {
//             var geoCoord = geoCoordMap[data[i].province];
//             if (geoCoord) {
//                 res.push({
//                     name: data[i].province,
//                     value: geoCoord.concat(data[i].count),
//                 });
//             }
//         }
//         return res;
//     };
//     option = {
//         title: {
//             text: name_title,
//             subtext: subname,
//             x: 'center',
//             textStyle: {
//                 color: nameColor,
//                 fontFamily: name_fontFamily,
//                 fontSize: name_fontSize
//             },
//             subtextStyle: {
//                 fontSize: subname_fontSize,
//                 fontFamily: name_fontFamily
//             }
//         },
//         tooltip: {
//             trigger: 'item',
//             formatter: function(params) {
//                 if (typeof(params.value)[2] == "undefined") {
//                     var toolTiphtml = ''
//                     for (var i = 0; i < data.length; i++) {
//                         if (params.name == data[i].province) {
//                             toolTiphtml += data[i].province + '<br>'
//                             if(null!=data[i].companyName && data[i].companyName.length>0){
//                                 toolTiphtml += data[i].companyName + "<br>"
//
//                             }
//                         }
//                     }
//                     return toolTiphtml;
//                 } else {
//                     var toolTiphtml = ''
//                     for (var i = 0; i < data.length; i++) {
//                         if (params.name == data[i].province) {
//                             toolTiphtml += data[i].province + '<br>'
//                             if(null!=data[i].companyName && data[i].companyName.length>0){
//                                 toolTiphtml += data[i].companyName + "<br>"
//
//                             }
//                         }
//                     }
//                     return toolTiphtml;
//                 }
//             }
//         },
//         visualMap: {
//             show: true,
//             min: 0,
//             max: 30,
//             left: 'left',
//             top: 'bottom',
//             text: ['高', '低'], // 文本，默认为数值文本
//             calculable: true,
//             seriesIndex: [1],
//             inRange: {
//                 color: ['#e6d0d0', '#3ab8f2','orange'] // 蓝绿
//             }
//         },
//
//         geo: {
//             show: true,
//             map: mapName,
//             label: {
//                 normal: {
//                     show: false
//                 },
//                 emphasis: {
//                     show: false,
//                 }
//             },
//             roam: true,
//             itemStyle: {
//                 normal: {
//                     areaColor: '#ebf2f5',//地图背景
//                     borderColor: '#3B5077',
//                 },
//                 emphasis: {
//                     areaColor: 'orange',
//                 }
//             }
//         },
//         series: [{
//             name: '散点',
//             type: 'scatter',
//             coordinateSystem: 'geo',
//             data: convertData(data),
//             symbolSize: function(val) {
//                 return val[2] / 10;
//             },
//             label: {
//                 normal: {
//                     formatter: '{b}',
//                     position: 'right', //身份标签位置
//                     show: true
//                 },
//                 emphasis: {
//                     show: true
//                 }
//             },
//             itemStyle: {
//                 normal: {
//                     color: 'black'
//                 }
//             }
//         },
//             {
//                 type: 'map',
//                 map: mapName,
//                 geoIndex: 0,
//                 aspectScale: 0.75, //长宽比
//                 showLegendSymbol: false, // 存在legend时显示
//                 label: {
//                     normal: {
//                         show: true
//                     },
//                     emphasis: {
//                         show: false,
//                         textStyle: {
//                             color: 'white'
//                         }
//                     }
//                 },
//                 roam: true,
//                 itemStyle: {
//                     normal: {
//                         areaColor: '#d1e1e8',
//                         borderColor: '#3B5077',
//                     },
//                     emphasis: {
//                         areaColor: '#2B91B7'
//                     }
//                 },
//                 animation: false,
//                 data: data
//             },
//             {
//                 name: '点',
//                 type: 'scatter',
//                 coordinateSystem: 'geo',
//                 symbol: 'pin', //气泡
//                 symbolSize: function(val) {
//                     var a = (maxSize4Pin - minSize4Pin) / (max - min);
//                     var b = minSize4Pin - a * min;
//                     b = maxSize4Pin - a * max;
//                     return a * val[2] + b;
//                 },
//                 label: {
//                     normal: {
//                         formatter:function(obj){
//                             return obj.data.value[2];
//                         },
//                         show: true,
//                         textStyle: {
//                             color: 'white',
//                             fontSize: 9,
//                         }
//                     }
//
//                 },
//                 itemStyle: {
//                     normal: {
//                         color: 'green', //标志颜色
//                     }
//                 },
//                 zlevel: 6,
//                 data: convertData(data),
//             },
//         ]
//     };
//     myChart.setOption(option);
// })