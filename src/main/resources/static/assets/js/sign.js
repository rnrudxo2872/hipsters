const emailClick = document.getElementById('email_auth'); //이메일 인증키 전송 버튼
const emailValue = document.getElementById('email'); //이메일 input값


const emailClickEvent = (event) => {
    
    if(emailValue.value == ""){
        alert('이메일을 입력하세요.');
        emailValue.focus();
        return false;
        
    }else{

    const userEmail = emailValue.value;


        $.ajax({
            type:'post',
            url:'/signup/emailCK',
            data:{
                userEmail: userEmail
            },
            dataType:'json',
            success : function(key){
                alert("제발돼시발러마"+key)
                const emailAuthCK = document.getElementById('authNumCK'); //이메일 인증번호 인증하기 버튼
                const emailAuthNum = document.getElementById('emailNum'); //이메일 인증번호 input값
                
                const eamilAuthCKEvent = (event) => {
                
                    if(emailAuthNum.value == key){
                    }
                
                }
                emailAuthCK.addEventListener('click',eamilAuthCKEvent); //이메일 인증키 인증하기 클릭 리스너
                
            }
            
        });

        alert("인증번호 전송완료");

    window.open("signup/email?userEmail="+userEmail,"","width=600, height=600");

    
    }   
}

if(emailClick){
emailClick.addEventListener('click',emailClickEvent); }//이메일 인증키 전송버튼 클릭 리스너




