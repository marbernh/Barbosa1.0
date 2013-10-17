/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var seconds;
var ticker;

function startTimer(secs) {
    seconds = parseInt(secs) - 1;
    ticker = setInterval("tick()", 1000);   // varje sec
}

function tick() {
    var secs = seconds;
    if (secs > 0) {
        seconds--;
    }
    else {
        clearInterval(ticker); // stanna vid 0.
        // startTimer(30);  // repeat....
    }

    document.getElementById("countdown").innerHTML = secs;
}

startTimer(30);  // start.
