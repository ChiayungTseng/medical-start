function arenaLoad() {
    var al = requestObj("ArenaLoad",teamId);
    console.log(JSON.stringify(al));
    socket.send(JSON.stringify(al));
}

function ArenaStart(arena){
    $('#panel').empty();
    $("#panel").hide();
    $("#headButton").hide();
    $("#arena").show();
    arenaBeing=arena;
    var teamMap = arena.teamMap;
    for(var key in teamMap){
        var team = teamMap[key];
        if(teamId ==team.id){
            $('#ourScore').text(team.scores);
            var warriorMap =team.warriorMap;
            var index =0;
            console.log(warriorMap);
            for(var wkey in warriorMap){//添加队友列
                $('#teammateRow').append('<br>');
                var warriorVal = warriorMap[wkey];
                var row = $("<div class='row'></div>");
                var col = $("<div class='col-xs-12'></div>");
                col.attr("style","padding-left:0px; padding-right:0px;");//background:green
                col.attr("id","w-"+warriorVal.id)
                var img = $("<img class='col-xs-12 img-circle'>");
                img.attr("src",warriorVal.imageUrl);
                img.attr("style","padding-left:1px; padding-right:1px;");
                col.append(img);
                row.append(col);
                $('#teammateRow').append(row);
                $('#teammateRow').append('<br>');
                $('#teammateRow').append('<br>');
                index = index+1;
            }
        }else {
            $('#deScore').text(team.scores);
            var warriorMap =team.warriorMap;
            var index =0;
            for(var wkey in warriorMap){//添加队友列
                $('#defenderRow').append('<br>');
                var warriorVal = warriorMap[wkey];
                var row = $("<div class='row'></div>");
                var col = $("<div class='col-xs-12'></div>");
                col.attr("style","padding-left:0px; padding-right:0px;");
                col.attr("id","w-"+warriorVal.id)
                var img = $("<img class='col-xs-12 img-circle'>");
                img.attr("src",warriorVal.imageUrl);
                img.attr("style","padding-left:3px; padding-right:3px;");
                col.append(img);
                row.append(col);
                $('#defenderRow').append(row);
                $('#defenderRow').append('<br>');
                $('#defenderRow').append('<br>');
            }
        }
        $('#questionPanel').text("答题即将开始");
        timeRefresh(arena.prepareSeconds);
        timer=setInterval(timeCount,500);
    }
}

function RoundStart(round) {

    var question =arenaBeing.questionList[round.round]
    $('#questionPanel').text(question.sentence);
    var index =0;
    selectionButtonInfo();
    warriorInitial();
    selectionTagEmpty();
    for (var selection of question.selectionList) {
        $('#selection'+index).text(selection.content);
        index ++;
    }
    timeRefresh(round.secondsGap);
}

function timeRefresh(timeGap){
    oldDate = new Date();
    seconds=timeGap;
    $('#timeCount').text(timeGap);
}

function timeCount(){
    var nowDate = new Date();
    var spendSeconds = parseInt((nowDate - oldDate) / 1000);
    var remainSeconds = seconds-spendSeconds;
    if(remainSeconds>=0){
        $('#timeCount').text(remainSeconds);
    }else{
        clearInterval(timer);//好像没有效果
    }
}
function selection(index){
    selectionButtonDisable();
    var answerSelection =new Object();
    answerSelection.warriorId= warrior.id;
    answerSelection.answerIndex = index;
    answerSelection.teamId =teamId;
    answerSelection.arenaId =arenaBeing.id;
    var tbrq = requestObj("AnswerSelection",answerSelection);
    socket.send(JSON.stringify(tbrq));
}

function AnswerSelection(arena){
    var teamMap = arena.teamMap;
    for(var teamKey in teamMap){
        var team = teamMap[teamKey];
        if(teamId ==team.id){
            $('#ourScore').text(team.scores);
        }else{
            $('#deScore').text(team.scores);
        }
    }
    var question = arena.questionList[arena.nowQuestionIndex];


    var teamGroupAnswer = arena.questionSelectionMap[arena.nowQuestionIndex];
    //图标变色
    // console.log(teamGroupAnswer);
    var hasAnswer = false;
    var answerIndex;
    var rightIndex = question.rightAnswerIndex;
    for(var teamKey in teamGroupAnswer.teamMap){
        var warriorSelectionList = teamGroupAnswer.teamMap[teamKey];
        for(var warriorSelection of warriorSelectionList){
            if(warriorSelection.correct){
                warriorRight(warriorSelection.warriorId);
            }else{
                warriorWrong(warriorSelection.warriorId);
            }

            if(warriorSelection.warriorId==warrior.id){
                hasAnswer = true;
                answerIndex =warriorSelection.answerIndex;
            }
        }
    }

    if(hasAnswer){
        var index =0;
        questionPanelText(question.sentence+"<br>"+question.tips);
        for (var selection of question.selectionList) {
            selectionText(index,selection.content+": "+selection.tips);
            if(index==rightIndex){
                selectionRight(index);
            }else if(answerIndex==index){
                selectionWrong(index);
            }
            index ++;
        }
        selectionTagEmpty();
        for(var teamKey in teamGroupAnswer.teamMap){
            var warriorSelectionList = teamGroupAnswer.teamMap[teamKey];
            for(var warriorSelection of warriorSelectionList){
                var direction;
                if(teamKey==teamId){
                    direction="Left";
                }else{
                    direction="Right";
                }
                var warriorVal = arenaBeing.teamMap[teamKey].warriorMap[warriorSelection.warriorId];
                var img = $("<img class='col-xs-4 img-circle'>");
                img.attr("src",warriorVal.imageUrl);
                img.attr("style","padding-left:0px; padding-right:0px;");
                img.attr("width","20px");
                $("#selectionTag"+direction+warriorSelection.answerIndex).append(img);
            }
        }
    }
}

function warriorInitial(){
    $("div[id^='w-']").attr("style","padding-left:0px; padding-right:0px;");
}

function selectionTagEmpty() {
    $("div[id^='selectionTag']").empty();

}

function warriorRight(warriorId){
    $('#w-'+warriorId).attr("style","padding-left:0px; padding-right:0px;background:green");//background:green
}
function warriorWrong(warriorId){
    $('#w-'+warriorId).attr("style","padding-left:0px; padding-right:0px;background:red");//background:green
}

function selectionButtonDisable() {
    $("#selection0").attr('disabled','disabled');
    $("#selection1").attr('disabled','disabled');
    $("#selection2").attr('disabled','disabled');
    $("#selection3").attr('disabled','disabled');
}

function selectionButtonInfo() {
    for(var i=0;i<4;i++){
        $('#selection'+i).attr('disabled',false);
        $('#selection'+i).attr("class","btn btn-primary btn-info col-xs-12");
    }
}

function questionPanelText(content){
    $('#questionPanel').html(content);
}

function selectionText(index,content){
    $('#selection'+index).text(content);
}

function selectionRight(index) {
    $('#selection'+index).attr("class","btn btn-primary  btn-success  col-xs-12");
}

function selectionWrong(index) {
    $('#selection'+index).attr("class","btn btn-primary  btn-danger  col-xs-12");
}