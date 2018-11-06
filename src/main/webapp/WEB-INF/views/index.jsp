<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
  <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
  <body>
  <div class="panel panel-default">
    <div class="panel-heading">
      <strong>List Albums, songs, rock groups</strong>
    </div>
    <div class="panel-body">
      <form class="form-inline">
        <button type="button" onclick="AddTestData()">Add test data</button>
        <button type="button" onclick="ShowAllAlbums()">Show all albums</button>
        <button type="button" onclick="ShowAllSongPlayers()">Show all songplayers</button>
        <button type="button" onclick="ShowAllPeople()">Show all people</button>
        <button type="button" onclick="ShowAllRockGroups()">Show all rock groups</button>
      </form>
      <form class="form-inline">
        <label>Find by Song:</label>
        <select id="songSelect"></select>
        <button type="button" onclick="FindAllInstrumentalist()">Find all instrumentalist</button>
        <button type="button" onclick="FindAllAlbums()">Find all albums</button>
      </form>
      <form class="form-inline">
        <label>Find by Human:</label>
        <select id="humanSelect"></select>
        <button type="button" onclick="FindAllRockGroups()">Find all rock groups</button>
      </form>
    </div>
    <div class="panel-body" id="tableAlbums"></div>
  </div>
  <script>
      var service = 'http://localhost:8080/';
      var Data = {};
      var peopleArr = [];
      var pplNumArr = [];
      var rockGroupArr = [];
      var rgNumArr = [];
      var songPlayersArr = [];
      var albumArr = [];

      var FindAllRockGroups = function () {
          var humanSelect = document.getElementById('humanSelect');
          var peopleObj = {};
          var rockGroupObj = {};
          $.ajax({
              type: 'GET',
              url: service + 'people/getbyhuman/' + humanSelect.value,
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>human</'+'th>';
                  output+= '<th>rock group</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      peopleObj = arrData[i];
                      rockGroupObj = peopleObj.rockGroups;
                      output += '<tr>';
                      output += '<th>' + humanSelect.value + '</' + 'th>';
                      output += '<th>' + rockGroupObj.rockGroup + '</' + 'th>';
                      output += '</' + 'tr>';
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var FindAllAlbums = function () {
          var songSelect = document.getElementById('songSelect');
          var songPlayerObj = {};
          var albumArr = [];
          $.ajax({
              type: 'GET',
              url: service + 'songplayers/getbysong/' + songSelect.value,
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>song</'+'th>';
                  output+= '<th>album</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      songPlayerObj = arrData[i];
                      output += '<tr>';
                      output += '<th>' + songSelect.value + '</' + 'th>';
                      output += '<th>' + songPlayerObj.album + '</' + 'th>';
                      output += '</' + 'tr>';
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var FindAllInstrumentalist = function () {
          var songSelect = document.getElementById('songSelect');
          var songPlayerObj = {};
          var songInstrumentalistArr = [];
          $.ajax({
              type: 'GET',
              url: service + 'songplayers/getbysong/' + songSelect.value,
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>song</'+'th>';
                  output+= '<th>instrumentalist</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      songPlayerObj = arrData[i];
                      songInstrumentalistArr = songPlayerObj.songInstrumentalistList;
                      for (k in songInstrumentalistArr){
                          output += '<tr>';
                          output += '<th>' + songSelect.value + '</' + 'th>';
                          output += '<th>' + songInstrumentalistArr[k].human + '</' + 'th>';
                          output += '</' + 'tr>';
                      }
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var AddTestData = function () {
          var j;
          var k;
          var i;
          console.log('AddTestData');
          //добавляем людей
          for (i = 0; i < 12; i++){
              AddPeople(i);
          }
          //получаем список людей
          GetPeopleArr();
          //добавляем композиции
          console.log('------ AddSongPlayers --------');
          i = 0;
          j = 0;
          while (i < 30){
              for (k = 0; k < 3; k++){
                  pplNumArr[i] = j;
                  i++;
              }
              j++;
          }
          for (i = 0; i < 30; i++){
              AddSongPlayers(i);
          }
          //добавляем рок группы
          i = 0;
          j = 0;
          while (i < 12){
              for (k = 0; k < 2; k++){
                  rgNumArr[i] = j;
                  i++;
              }
              j++;
          }
           console.log('rgNumArr=' + rgNumArr);
          for (i = 0; i < 6; i++){
              AddRockGroups(i);
          }
          //получаем список рок групп
          GetRockGroupsArr();
          //привязываем каждому человеку рок группу
          console.log('------ UpdPeopleRockGroup --------');
          for (i = 0; i < 12; i++) {
              UpdPeopleRockGroup(i);
          }
          //добавляем альбомы
          console.log('------ AddAlbum --------');
          for (i = 0; i < 10; i++){
              AddAlbum(i);
          }
          //получаем композиции
          GetSongPlayersArr();
          //получаем альбомы
          GetAlbumArr();
          //к альбомам привязываем композиции
          console.log('------ UpdAlbum --------');
          for (i = 0; i < 10; i++) {
              UpdAlbum(i);
          }
          //заполняем выпадающий список
          SetSelectOptions();
      };

      var UpdAlbum = function (i) {
          var albumObj = albumArr[i];
          var spArr = [];
          var songPlayersObj0 = songPlayersArr[i*3];
          spArr.push(songPlayersObj0);
          var songPlayersObj1 = songPlayersArr[i*3 + 1];
          spArr.push(songPlayersObj1);
          var songPlayersObj2 = songPlayersArr[i*3 + 2];
          spArr.push(songPlayersObj2);
          albumObj.songPlayersList = spArr;
          // console.log(albumObj);
          $.ajax({
              type: 'PUT',
              url: service + "album/upd",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(albumObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  albumObj = JSON.parse(stringData);
                  console.log(albumObj);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var GetAlbumArr = function () {
          $.ajax({
              type: 'GET',
              url: service + 'album/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  albumArr = JSON.parse(stringData);
                  console.log(albumArr);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var GetSongPlayersArr = function () {
          $.ajax({
              type: 'GET',
              url: service + 'songplayers/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  songPlayersArr = JSON.parse(stringData);
                  console.log(songPlayersArr);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var AddAlbum = function (i) {
            var album = "Album" + i;
            var albumObj = {
                'album':album
            };
          $.ajax({
              type: 'POST',
              url: service + "album/add",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(albumObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  Data = JSON.parse(stringData);
                  console.log(Data);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var UpdPeopleRockGroup = function (i) {
          var peopleObj = peopleArr[i];
          var rgNum = rgNumArr[i];
          peopleObj.rockGroups = rockGroupArr[rgNum];
          // console.log(peopleObj);
          $.ajax({
              type: 'PUT',
              url: service + "people/upd",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(peopleObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  peopleObj = JSON.parse(stringData);
                  console.log(peopleObj);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var GetRockGroupsArr = function () {
          $.ajax({
              type: 'GET',
              url: service + 'rockgroups/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  rockGroupArr = JSON.parse(stringData);
                  console.log(rockGroupArr);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var AddRockGroups = function (i) {
          var rockGroup = "Group" + i;
        var rockGroupsObj = {
          'rockGroup':rockGroup
        };
          $.ajax({
              type: 'POST',
              url: service + "rockgroups/add",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(rockGroupsObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  Data = JSON.parse(stringData);
                  console.log(Data);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };
      
      var AddSongPlayers = function (i) {
        var songPlayersSong = "Song" + i;
        var songPlayersComposer = "Human" + pplNumArr[i];
        var songPlayersPoet = "Human" + (pplNumArr[i] + 1);
        var songPlayersAlbum = "Album" + pplNumArr[i];
        var songPlayersInstrumentalistObj1 = peopleArr[pplNumArr[i] + 1];
        var songPlayersInstrumentalistObj2 = peopleArr[pplNumArr[i] + 2];
          var songPlayersObj = {
              'song':songPlayersSong,
              'composer':songPlayersComposer,
              'poet':songPlayersPoet,
              'album':songPlayersAlbum,
              'songInstrumentalist':[songPlayersInstrumentalistObj1, songPlayersInstrumentalistObj2]
          };
          $.ajax({
              type: 'POST',
              url: service + "songplayers/add",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(songPlayersObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  Data = JSON.parse(stringData);
                  console.log(Data);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });

      };

      var GetPeopleArr = function () {
          $.ajax({
              type: 'GET',
              url: service + 'people/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  peopleArr = JSON.parse(stringData);
                  console.log(peopleArr);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };
      
      var AddPeople = function (i) {
          var humanName = "Human" + i;
          var peopleObj = {
              'human':humanName
          };
          $.ajax({
              type: 'POST',
              url: service + "people/add",
              contentType: 'application/json;charset=utf-8',
              data: JSON.stringify(peopleObj),
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  Data = JSON.parse(stringData);
                  console.log(Data);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var ShowAllRockGroups = function () {
          console.log('ShowAllRockGroups');
          $.ajax({
              type: 'GET',
              url: service + 'rockgroups/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>id</'+'th>';
                  output+= '<th>RockGroup</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      output += '<tr>';
                      output += '<th>' + arrData[i].id + '</' + 'th>';
                      output += '<th>' + arrData[i].rockGroup + '</' + 'th>';
                      output += '</' + 'tr>';
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var ShowAllPeople = function () {
          console.log('ShowAllPeople');
          $.ajax({
              type: 'GET',
              url: service + 'people/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>id</'+'th>';
                  output+= '<th>Human</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                          output += '<tr>';
                          output += '<th>' + arrData[i].id + '</' + 'th>';
                          output += '<th>' + arrData[i].human + '</' + 'th>';
                          output += '</' + 'tr>';
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }

          });
      };

      var ShowAllSongPlayers = function () {
          console.log('ShowAllSongPlayers');
          $.ajax({
              type: 'GET',
              url: service + 'songplayers/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>id</'+'th>';
                  output+= '<th>Song</'+'th>';
                  output+= '<th>Composer</'+'th>';
                  output+= '<th>Poet</'+'th>';
                  output+= '<th>Album</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      output += '<tr>';
                      output += '<th>' + arrData[i].id + '</' + 'th>';
                      output += '<th>' + arrData[i].song + '</' + 'th>';
                      output += '<th>' + arrData[i].composer + '</' + 'th>';
                      output += '<th>' + arrData[i].poet + '</' + 'th>';
                      output += '<th>' + arrData[i].album + '</' + 'th>';
                      output += '</' + 'tr>';
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var ShowAllAlbums = function () {
          var songPlayersListArr = [];
          var songPlayersListObj = {};
          console.log('ShowAllAlbums');
          $.ajax({
              type: 'GET',
              url: service + 'album/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var output = '';
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  output+= '<table class="table-row-cell" border="1">';
                  output+= '<tr>';
                  output+= '<th>id</'+'th>';
                  output+= '<th>Album</'+'th>';
                  output+= '<th>Song</'+'th>';
                  output+= '</' +'tr>';

                  for (i in arrData) {
                      songPlayersListArr = arrData[i].songPlayersList;
                      for (k in songPlayersListArr) {
                          output += '<tr>';
                          output += '<th>' + arrData[i].id + '</' + 'th>';
                          output += '<th>' + arrData[i].album + '</' + 'th>';
                          songPlayersListObj = songPlayersListArr[k];
                          output += '<th>' + songPlayersListObj.song  + '</' + 'th>';
                          output += '</' + 'tr>';
                      }
                  }

                  output+= '</' +'table>';
                  $('#tableAlbums').html(output);
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var SetSelectOptions = function (){
          console.log('SetSelectOptions');
          $.ajax({
              type: 'GET',
              url: service + 'songplayers/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  // console.log(stringData);
                  var arrData = JSON.parse(stringData);
                  for (i in arrData) {
                      var songPlayersObj = {};
                      songPlayersObj = arrData[i];
                      $("#songSelect").append($('<'+'option value'+'="'+songPlayersObj.song+'">'+songPlayersObj.song+'</option>'))
                  }
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      var SetSelectByHuman = function (){
          console.log('SetSelectByHuman');
          $.ajax({
              type: 'GET',
              url: service + 'people/all',
              dataType: 'json',
              async: false,
              success: function (result) {
                  var stringData = JSON.stringify(result);
                  var arrData = JSON.parse(stringData);
                  console.log(arrData);
                  var arrData = JSON.parse(stringData);
                  for (i in arrData) {
                      var peopleObj = {};
                      peopleObj = arrData[i];
                      $("#humanSelect").append($('<'+'option value'+'="'+peopleObj.human+'">'+peopleObj.human+'</option>'))
                  }
              },
              error: function (jqXHR, testStatus, errorThrown) {
                  $('#tableAlbums').html(JSON.stringify(jqXHR))
              }
          });
      };

      SetSelectOptions();
      SetSelectByHuman();
  </script>
  </body>
</html>
