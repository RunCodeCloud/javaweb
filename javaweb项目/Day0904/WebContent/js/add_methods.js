jQuery.validator.addMethod("isPhone",function(value,element){
	
	var phoneReg = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;
	
	//this.optional(element);   表示，不填不验证，填写再验证
    return (this.optional(element)) || (phoneReg.test(value));

},"请填写正确的手机号");
