const maxSize= 2;

export function fileValidator(fileObject) {
    console.log("file size value",fileObject.size);
    console.log("file type -",fileObject.type);
    var arr = [ "image/jpeg","image/jpeg", "image/png", "image/PNG", "application/vnd.ms-excel","application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/pdf" , "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ];
    var fileSizeinMB = fileObject.size / (1024 * 1000);
    console.log("size of file in mb",fileSizeinMB);
    var size = Math.round(fileSizeinMB * 100) / 100; // convert upto 2 decimal place
    console.log("size in mb",size);
    
    for(var i=0; i < arr.length; i++) {
      
        
        if(fileObject.type ==  arr[i] && size < maxSize)
        {
            console.log("image inserted");

         
          
           return true;
        }
      
    }

}
