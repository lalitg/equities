

$(document).ready(function() {
    test();
});

function test(){
    $("#list_badges").simpletable({
        getURL : function(){
            return "http://localhost:8080/ShareInvestmentForum/portfolio/";
        },
        dataFormatter : function(dataraw){
            return dataraw.data;
        },
        deleteURL : function(idPrime){
           return "http://localhost:8080/ShareInvestmentForum/portfolio/"+idPrime;
        },
        editURL : function(idPrime){
            return "http://localhost:8080/ShareInvestmentForum/portfolio/"+idPrime;
        },
        addURL : function(idPrime){
            return "http://localhost:8080/ShareInvestmentForum/portfolio/";
        },
        customRenderView : {
            avatar : function(rowNum, idPrime, dataValue){
                //src='"+ badgeAccess.getBadgeImage(appId,idPrime) +"'
                return "<img class='text-center' src='"+dataValue+"' alt='your image' />";
            }
        },
        customRenderEdit : {
            avatar : function(rowNum, idPrime, dataValue){
                return "<input type=\"file\" name=\"pic\" id=\"avatarimg\" accept=\"image/*\">";
            }
        },
        customSave : {
            avatar : function(rowNum, idPrime){
                var photo = document.getElementById("avatarimg");
                // the file is the first element in the files property
                var file = photo.files[0];

                console.log(file);
                return file;
            }
        },
        format : "json"
    });
}