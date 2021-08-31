const emailClick = document.getElementById('email_auth'); //이메일 인증키 전송 버튼
const emailValue = document.getElementById('email'); //이메일 input값

const emailAuthCK = document.getElementById('authNumCK'); //이메일 인증번호 인증하기 버튼
const emailAuthNum = document.getElementById('emailNum'); //이메일 인증번호 input값


const email = async () => {}

async function email2 () {

}

const emailClickEvent = async (event) => {
    
    if(emailValue.value == ""){
        alert('이메일을 입력하세요.');
        emailValue.focus();
        return false;
        
    }else{

    const userEmail = emailValue.value;

        //----------------

        $.ajax({
            type:'post',
            url:'/signup/emailCK',
            data:{
                userEmail: userEmail
            },
            dataType:'json',
            success : function(key){
                alert("제발돼시발러마"+key)
            }
        });

        //----------------

        // const body = {
        //     userEmail:userEmail
        // }

        // const header = {
        //     method:'POST',
        //     body:JSON.stringify(body)
        // }

        // const result = await ( await fetch('/signup/emailCK', header)).json();
        



        // ----------------- json 결과 ------------------------

        // {
        //     key:12312424
        // }
        // =>    result.key


        //
        //  {
        //      right: true
        //  }
        //  => 비교 결과

        alert("인증번호 전송완료");

    window.open("signup/email?userEmail="+userEmail,"","width=600, height=600");

    
    }   
}

const eamilAuthCKEvent = (event) => {
    window.close();

    if(emailAuthNum.value == key){
    }

}

if(emailAuthCK){
    emailAuthCK.addEventListener('click',eamilAuthCKEvent); //이메일 인증키 인증하기 클릭 리스너
}

if(emailClick){
    emailClick.addEventListener('click',emailClickEvent); //이메일 인증키 전송버튼 클릭 리스너
}




