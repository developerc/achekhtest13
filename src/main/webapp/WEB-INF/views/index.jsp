<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
  <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
  <body>
  <script>
      var service = 'http://localhost:8080/';
      var Data = {};

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
  </script>
  <div class="panel panel-default">
    <div class="panel-heading">
      <strong>List Albums, songs, rock groups</strong>
    </div>
    <div class="panel-body">
      <form class="form-inline">
        <button type="button" onclick="ShowAllAlbums()">Show all albums</button>
        <button type="button" onclick="ShowAllSongPlayers()">Show all songplayers</button>

        <button type="button" onclick="ShowAllPeople()">Show all people</button>
        <button type="button" onclick="ShowAllRockGroups()">Show all rock groups</button>
      </form>
    </div>
    <div class="panel-body" id="tableAlbums"></div>
  </div>
  </body>
</html>
