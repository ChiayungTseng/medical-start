

function teamRefresh(team){
    $('#panel').show();
    $('#teamId').text(team.id);
    var warriorMap = team.warriorMap;
    for(var key in warriorMap){
        var warrior = warriorMap[key];
        var tr = $("<tr></tr>");
        var td = $("<td></td>");
        var img = $("<img>");
        img.attr("class","col-xs-4 img-circle");
        img.attr("src",warrior.imageUrl);
        td.append(img);
        tr.append(td);
        $('#teamTableBody').append(tr);
    }
}

function teamBuild() {
    var tbrq = requestObj("TeamBuild",null);
    socket.send(JSON.stringify(tbrq));
}

function teamJoin() {
    var reqData = new Object();
    reqData.teamId =$('#teamJoinId').val();
    var tjrq = requestObj("TeamJoin",reqData);
    console.log(JSON.stringify(tjrq));
    socket.send(JSON.stringify(tjrq));
}