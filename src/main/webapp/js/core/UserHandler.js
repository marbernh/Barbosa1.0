/***********************************************
 *  
 *  A proxy representing the product service (model)
 *   NOTE: All methods return deferred object, see JQuery
 *  
 */
// var ProductCatalogue ;
var UserRegister = function(baseUri){
    this.baseUri = baseUri;
};

UserRegister.prototype = (function (){
    return{
        
        add: function(user){
            return $.ajax({
                type: 'POST',
                url: this.baseUri,
                data: user
            });
        },
                
        remove: function(id){
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + id
            });
        },
            
        update: function(user){
            return $.ajax({
                type: 'PUT',
                url: this.baseUri + "/" + product.id,
                data: {id:user.id, userName:user.userName, password:user.password}
            });
        },
        
        find: function(id){
        return $.getJSON(this.baseUri + "/" + id);    
        }
    };
}());

