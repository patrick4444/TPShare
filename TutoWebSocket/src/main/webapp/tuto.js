
var socket = new WebSocket("ws://localhost:8080/TutoWebSocket/tuto");

socket.onmessage = function(event){
	console.dir(event);
	console.log(event.data);
	var data = JSON.parse(event.data);
	console.dir(data);
	console.log(data.c);
	console.log(data.d);
};

setTimeout(function(){
	var data = {
		a : 100,
		b : "coucou"
	};
    socket.send(JSON.stringify(data));    
},1000);
