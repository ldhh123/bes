(function(win){var XDate=new Function();var $={ID:"datebox",FID:"iframe_hide",PYD:"_span_year",PMD:"_span_month",PWD:"_span_week",PDD:"_span_day",PTD:"a_today",PHD:"_span_hours",PmD:"_span_minutes",PSD:"_span_seconds",TID:"div_time",PCD:"span_copyright",YID:"_select_year",MID:"_select_month",HID:"_select_hours",mID:"_select_minutes",SID:"_select_seconds",OBJ:"",DF:"dateformat",F:"yyyy-MM-dd"};function click(e){e=window.event||e;var obj=e.srcElement?e.srcElement:e.target;var fm=obj.getAttribute($.DF);var d=new XDate();if(fm!=null&&fm!=""){d.show(obj,fm)}else{d.close()}}function init(){var d=new XDate();var n=new Date();d.createBox();d.putSelect($.YID,1900,2100,$.PYD,n.format("yyyy"));d.putSelect($.MID,1,13,$.PMD,n.format("M"));d.putWeek();d.putDay();d.putToDay();d.putSelect($.HID,0,24,$.PHD,n.format("hh"),true);d.putSelect($.mID,0,60,$.PmD,n.format("mm"),true);d.putSelect($.SID,0,60,$.PSD,0,true);d.putCopyRight()}XDate.prototype={createBox:function(){var body=$T("BODY").item(0);var ifr=$C("IFRAME");ifr.id=$.FID;ifr.setAttribute("frameBorder","0");ifr.setAttribute("scrolling","no");ifr.src="about:blank";body.appendChild(ifr);var div=$C("DIV");div.id=$.ID;div.onclick=this.cancelBubble;var h='<a href="javascript:$date.yearButton()">\u2264</a> &nbsp;';h+='<a href="javascript:$date.monthButton()">\uff1c</a> &nbsp;';h+='<span id="_span_year"></span>\u5e74';h+='<span id="_span_month"></span>\u6708 &nbsp;';h+='<a href="javascript:$date.monthButton(true)">\uff1e</a> &nbsp;';h+='<a href="javascript:$date.yearButton(true)">\u2265</a>';h+='<span id="_span_week"></span>';h+='<span id="_span_day"></span>';h+='<div id="div_time"><span id="_span_hours"></span>:<span id="_span_minutes"></span>:<span id="_span_seconds"></span></div>';h+='<a id="a_today" href="javascript:$date.currentDate()"></a> &nbsp; &nbsp;';h+='<a href="javascript:$date.evaluate()">\u786e\u5b9a</a> &nbsp;';h+='<a href="javascript:$date.clear()">\u6e05\u9664</a> &nbsp;';h+='<a href="javascript:$date.close()">\u53d6\u6d88</a><br>';h+='<span id="span_copyright"></span>';div.innerHTML=h;body.appendChild(div)},show:function(obj,fm){$.OBJ=obj.name;var pos=getPos(obj);var top=pos.top+obj.offsetHeight+"px";var left=pos.left+"px";var box=$D($.ID);box.style.top=top;box.style.left=left;box.style.visibility="visible";var ifr=$D($.FID);ifr.style.top=top;ifr.style.left=left;ifr.style.width=box.offsetWidth+"px";ifr.style.height=box.offsetHeight+"px";ifr.style.visibility="visible";$.F=fm;if(fm.indexOf("hh:mm")>-1){$D($.TID).style.visibility="visible"}else{$D($.TID).style.visibility="hidden"}},close:function(){var box=$D($.ID);box.style.visibility="hidden";var ifr=$D($.FID);ifr.style.visibility="hidden";$D($.TID).style.visibility="hidden"},clear:function(){$N($.OBJ)[0].value="";this.close()},putSelect:function(id,startN,endN,pid,v,bool){var h='<select id="'+id+'" onchange="$date.putDay()">';for(var i=startN;i<endN;i++){if(bool){h+='<option value="'+a0(i)+'">'+a0(i)+"</option>"}else{h+='<option value="'+i+'">'+i+"</option>"}}h+="</select>";$D(pid).innerHTML=h;$D(id).value=v},putWeek:function(){var week=new Array("\u65e5","\u4e00","\u4e8c","\u4e09","\u56db","\u4e94","\u516d");var h="";for(var i=0;i<7;i++){h+="<th>"+week[i]+"</th>"}$D($.PWD).innerHTML=this.getTable(h)},evaluate:function(obj){var year=$D($.YID).value;var month=$D($.MID).value;var day=new Date().format("d");if(obj!=undefined){day=obj.id}var hours=$D($.HID).value;var minutes=$D($.mID).value;var seconds=$D($.SID).value;var date=new Date(year,month-1,day,hours,minutes,seconds);$N($.OBJ)[0].value=date.format($.F);this.close()},currentDate:function(){var d=new Date();var year=d.format("yyyy");var month=d.format("M");var day=d.format("d");var hours=d.format("hh");var minutes=d.format("mm");var seconds=d.format("ss");$D($.YID).value=year;$D($.MID).value=month;$D($.HID).value=hours;$D($.mID).value=minutes;$D($.SID).value=seconds;this.putDay();$N($.OBJ)[0].value=d.format($.F);this.close()},putDay:function(){var _now=new Date();var _year=_now.format("yyyy");var _month=_now.format("M");var _day=_now.format("d");var y=$D($.YID).value;var m=$D($.MID).value;var tmpd=_day;if(y!=_year||m!=_month){tmpd=1}var temp=new Date(y,m-1,1);var w=temp.getDay();var d;if(m==2){if(y%4==0||y%100!=0&&y%400==0){d=30}else{d=29}}if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){d=32}if(m==4||m==6||m==9||m==11){d=31}var t="";for(var i=0;i<w;i++){t+="<td>&nbsp;</td>"}for(var i=1;i<d;i++){if(w==7){w=0;t+="<tr><tr>"}if(i==tmpd){t+='<td id="'+i+'" class="td_today" onclick="$date.evaluate(this)" onmouseover="$date.isTdMouseOut(this)" onmouseout="$date.isTdMouseOut(this)">'+i+"</td>"}else{t+='<td id="'+i+'" onclick="$date.evaluate(this)" onmouseover="$date.isTdMouseOut(this)" onmouseout="$date.isTdMouseOut(this)">'+i+"</td>"}w++}$D($.PDD).innerHTML=this.getTable(t);if(getIe()<7){var box=$D($.ID);var ifr=$D($.FID);ifr.style.width=box.offsetWidth+"px";ifr.style.height=box.offsetHeight+"px"}},getTable:function(context){var t='<table width="100%" border="0" cellspacing="0" cellpadding="2">';t+="<tr>";t+=context;t+="</tr>";t+="</table>";return t},putToDay:function(){$D($.PTD).innerHTML=new Date().format($.F.substring(0,10))},isTdMouseOut:function(obj){var name=obj.className;if(name!="td_today"){if(name=="td_mousemove"){obj.className=""}else{obj.className="td_mousemove"}}},monthButton:function(bool){var month=Number($D($.MID).value);var year=Number($D($.YID).value);if(bool&&month==12){if(year==2099){return}year++;month=0}if(!bool&&month==1){var year=$D($.YID).value;if(year==1900){return}year--;month=13}if(bool){month++}else{month--}$D($.YID).value=year;$D($.MID).value=month;this.putDay()},yearButton:function(bool){var year=Number($D($.YID).value);if(!bool&&year==1900){return}if(bool&&year==2099){return}if(bool){year++}else{year--}$D($.YID).value=year;this.putDay()},putCopyRight:function(){eval(unescape("%24%44%28%24%2E%50%43%44%29%2E%69%6E%6E%65%72%48%54%4D%4C%20%3D%20%27%40%61%75%74%68%6F%72%3A%48%6F%6E%67%68%6F%6E%67%20%51%51%3A%36%35%30%33%35%38%37%36%27%3B"))},cancelBubble:function(evt){if(window.event){event.cancelBubble=true}else{if(evt){evt.stopPropagation()}}}};addEvent(window,"load",init);addEvent(document,"click",function(e){click(e)});function addEvent(obj,caseName,functionName){if(document.all){obj.attachEvent("on"+caseName,functionName)}else{obj.addEventListener(caseName,functionName,false)}}function getPos(obj){var pos={top:0,left:0};if(obj.offsetParent){while(obj.offsetParent){pos.top+=obj.offsetTop;pos.left+=obj.offsetLeft;obj=obj.offsetParent}}else{if(obj.x){pos.left+=obj.x}else{if(obj.x){pos.top+=obj.y}}}return pos}function getIe(){if(navigator.userAgent.indexOf("MSIE")>0){var ver=navigator.appVersion;var vNumber=parseFloat(ver.substring(ver.indexOf("MSIE")+5,ver.lastIndexOf("Windows")));return vNumber}}function $D(id){return document.getElementById(id)}function $N(name){return document.getElementsByName(name)}function $T(name){return document.getElementsByTagName(name)}function $C(type){return document.createElement(type)}function a0(s){return((s<10)?"0":"")+s}Date.prototype.format=function(format){var o={"M+":this.getMonth()+1,"d+":this.getDate(),"h+":this.getHours(),"m+":this.getMinutes(),"s+":this.getSeconds(),"q+":Math.floor((this.getMonth()+3)/3),S:this.getMilliseconds()};if(/(y+)/.test(format)){format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length))}for(var k in o){if(new RegExp("("+k+")").test(format)){format=format.replace(RegExp.$1,RegExp.$1.length==1?o[k]:("00"+o[k]).substr((""+o[k]).length))}}return format};win.XDate=XDate})(window);var $date=new XDate();
