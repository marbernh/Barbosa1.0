var quiz = (function(){
    
    var baseUri = "http://localhost:8080/Barbosa1.1/content/login.xhtml";  
    var register = new UserRegister(baseUri);
    
    return {
        getRegister : function(){
            return register;
        },
        getBaseUri : function(){
            return baseUri;
        }
    };    
})();