/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vera Lomander
 */
var myCounter = new Countdown({  
    seconds:30,  // number of seconds to count down
    updateStatus: function(seconds){console.log(seconds);}, // callback for each second
    counterEnd: function(){ alert('counter ended!');} // Utöka
});

myCounter.start();

function Countdown(options){
    var timer,
    seconds = options.seconds,
    updateStatus = options.UpdateStatus;
    
    function decreaseCounter(){
        updateStatus(seconds);
        if (seconds ===0) {
            counterEnd();
        }
        seconds--;
    };
    
    this.start = function (){
        cleatInterval(timer);
        timer=0;
        seconds = options.seconds;
        timer = setInterval(decreaseCounter, 1000);
    };
    
    this.stop = function(){
        clearInterval(timer);
    };
}