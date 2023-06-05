function fn1(){
    var userName=document.getElementById("userName").value;
    var password=document.getElementById("password").value;
    var fName=document.getElementById("fName").value;
    var lName=document.getElementById("lName").value;
    var emailId=document.getElementById("emailId").value;
    var rollNumber=document.getElementById("rollNumber").value;
    var hostel=document.getElementById("hostel").value;
    var roomNumber=document.getElementById("roomNumber").value;
    var passYear=document.getElementById("passYear").value;
    // var isTeacher=document.getElementById("isTeacher").value;
    // if(isTeacher==on)isTeacher=true;
    // else isTeacher=false;
    var isTeacher=false;
    if (document.getElementById("isTeacher").checked) {
        isTeacher=true;
    }
    console.log(userName);
    console.log(password);
    console.log(fName);
    console.log(lName);
    console.log(emailId);
    console.log(rollNumber);
    console.log(hostel);
    console.log(roomNumber);
    console.log(passYear);
    console.log(isTeacher);
    fetch("http://localhost:8080/create-user?userName="+userName+"&password="+password+"&fName="+fName+"&lName="+lName+"&emailId="+emailId+"&rollNumber="+rollNumber+"&hostel="+hostel+"&roomNumber="+rollNumber+"&passYear="+passYear+"&isTeacher="+isTeacher,{
    method: "POST",
    headers: {
        Accept:"application/json",
        "Content-Type":"application/json"
    }
  }).then(function(response){
        return response.text(); 
    }).then(function(jsonData){
        console.log(jsonData);
        var jsonD=jsonData;
    // var id=jsonData.PromiseResult;
    // var idElement=document.createElement("h2");
    // idElement.innerHTML=jsonData;
    // document.body.appendChild(idElement);
        // window.location= "guess.html?ID_Shown="+jsonD;
        // window.getElementById("ID_Shown").value=jsonD;
    // console.log(id);
})
}
function fn2(){
    var teacherUserName=document.getElementById("teacherUserName").value;
    var teacherPassword=document.getElementById("teacherPassword").value;
    var studentUserName=document.getElementById("studentUserName").value;
    console.log(teacherUserName);
    console.log(teacherPassword);
    console.log(studentUserName);
    fetch("http://localhost:8080/delete-user?teacherUserName="+teacherUserName+"&teacherPassword="+teacherPassword+"&studentUserName="+studentUserName,{
    method: "POST",
    headers: {
        Accept:"application/json",
        "Content-Type":"application/json"
    }
    }).then(function(response){
        return response.text(); 
    }).then(function(jsonData){
        console.log(jsonData);
        var jsonD=jsonData;
        var msg=document.createElement("h1");
        msg.innerHTML=jsonD;
        document.body.appendChild(msg);
        // var id=jsonData.PromiseResult;
        // var idElement=document.createElement("h2");
        // idElement.innerHTML=jsonData;
        // document.body.appendChild(idElement);
        // window.location= "guess.html?ID_Shown="+jsonD;
        // window.getElementById("ID_Shown").value=jsonD;
        // console.log(id);
    })

}