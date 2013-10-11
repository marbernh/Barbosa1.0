/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vera Lomander
 */

var count=30;

var counter=setInterval(timer, 1000); //1000 will  run it every 1 second

function timer()
{
  count=count-1;
  if (count <= 0)
  {
     clearInterval(counter);
     //counter ended, do something here
     return;
  }

  document.getElementById("timer").innerHTML=count + " secs"; 
}

//var myCounter = new Countdown({  
//    seconds:30,  // number of seconds to count down
//    updateStatus: function(seconds){console.log(seconds);}, // callback for each second
//    counterEnd: function(){ alert('counter ended!');} // Utöka
//});
//
//myCounter.start();
//
//function Countdown(options){
//    var timer,
//    seconds = options.seconds,
//    updateStatus = options.UpdateStatus;
//    
//    function decreaseCounter(){
//        updateStatus(seconds);
//        if (seconds ===0) {
//            counterEnd();
//        }
//        seconds--;
//    };
//    
//    this.start = function (){
//        cleatInterval(timer);
//        timer=0;
//        seconds = options.seconds;
//        timer = setInterval(decreaseCounter, 1000);
//    };
//    
//    this.stop = function(){
//        clearInterval(timer);
//    };
//}