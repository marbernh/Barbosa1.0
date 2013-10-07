/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vera Lomander
 */
var Timer = new Countdown( { style: "flip", time: 3600 } );

function countdownComplete(){
  	alert("Finished");
        
}
var myCountdown = new Countdown({
                         time  	: 15, // Total number of seconds to count down.	
                         width	  	: 200,      // Defaults to 200 x 30 pixels, you can specify a custom size here
                         height	 	: 30,       //
                         inline	 	: true,     // If inline, text will wrap around object, otherwise this countdown object will consume the entire "line"
                         target	 	: "foo", // A reference to an html DIV id (e.g. DIV id="foo")
                         style   	: "boring", // flip boring whatever (only "flip" uses image/animation)
                         padding        : 0.4,      // Padding between the digits and the background box. Value reflects a percentage of overall height.
                         onComplete	: countdownComplete, // Specify a function to call when done
                         numberMarginTop : 5.5,
                         
                        numbers	 : {
                             font : "Arial",
                             color	: "#FFFFFF",
                             bkgd	: "#365D8B",
                             rounded	: 0.15,	 // percentage of size 
                             shadow	: {
                                           x : 0,	 // x offset (in pixels)
                                           y : 3,	 // y offset (in pixels)
                                           s : 4,	 // spread
                                           c : "#000000",	// color
                                           a : 0.4
                                     }
                        }
});