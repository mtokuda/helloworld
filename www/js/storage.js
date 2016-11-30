// This is a JavaScript file


// データ削除
window.localStorage.removeItem('hoge');
// 全データクリア
window.localStorage.clear();

$(function () {
    $("#setItembtn").click(function(){
        alert("setItembtn");
        // データ保存
        window.localStorage.setItem('hoge', 'value');
	});
});

$(function () {
    $("#getItembtn").click(function(){
        alert("getItembtn");
        // データ取得
        var hoge = window.localStorage.getItem('hoge');
        alert("getItembtn value:" + hoge);
        
    });
});

function setItem(){
 
    var title = $("#todo-title").val();
    var body = $("#todo-body").val();
    
    // (5) Obtain the current time
    var now = new Date();
    alert("setItem()");
    
    $.mobile.changePage($("#list-page"));
    $("#todo-list").append(now);
    $("#todo-list").append("<li id=li1>" + "<h3>" + title + "</h3><p>" + body + "内容</p></li>");
//    $("#todo-list").append("<input type=\"checkbox\" name=\"riyu\" value=\"1\">完了(削除する)");
//    
////    $("#todo-list").append("<button id=\"remove\">remove</button>");
////    <input type="checkbox" name="riyu" value="1">チェックボックス
    $("#todo-list").listview('refresh');
    
    // データ保存
    localStorage.setItem(title, body);
    alert("localStorage.length:"+localStorage.length);
    
    
    var preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
    SharedPreferences.Editor editor = preferences.edit();
    editor.putString("value", value);
    editor.apply();
    
    
    
    alert(1);
    context=getActivity();
    alert(1.5);
    sp = getSharedPreferences("sampleCategory", MODE_PRIVATE);
    alert(2);
    sp.edit().putInt("sampleInt", 999).commit();
    alert(getResources().getInteger(sampleInt));
   
};