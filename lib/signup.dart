import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'HomePage.dart';
import 'login.dart';


String phones="";
String fname="";
String lname="";
String pass="";
String cpass="";
String Email="";

class signScreen extends StatefulWidget{
  @override
  _signScreenStat createState() => _signScreenStat();

}

class _signScreenStat extends State<signScreen> {
  bool rememberpwd = false;
  bool sec = true;
  var visable = Icon(
    Icons.visibility,
    color: Color(0xff4c5166),
  );
  var visableoff = Icon(
    Icons.visibility_off,
    color: Color(0xff4c5166),
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: AnnotatedRegion<SystemUiOverlayStyle>(
        value: SystemUiOverlayStyle.light,
        child: GestureDetector(
          child: Stack(
            children: [
              Container(
                height: double.infinity,
                width: double.infinity,
                decoration: BoxDecoration(
                  gradient: LinearGradient(
                    begin: Alignment.topCenter,
                    end: Alignment.bottomCenter,
                    colors: [
                      Color(0xff65b0bb),
                      Color(0xff5a9ea8),
                      Color(0xff508c95),
                      Color(0xff467b82),
                      Color(0xff3c6970),
                      Color(0xff32585d),
                      Color(0xff28464a),
                    ],
                  ),
                ),
                child: Padding(
                  padding: const EdgeInsets.only(right: 20, left: 20),
                  child: SingleChildScrollView(
                    child: Column(
                      children: [
                        SizedBox(height: 100,),
                        Text(
                          "Hello User! ☺️",
                          style: TextStyle(
                            color: Colors.white,
                            fontSize: 40,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        SizedBox(height: 100,),
                        buildfname(),
                        SizedBox(height: 50,),
                        buildlname(),
                        SizedBox(height: 50,),
                        buildEmail(),
                        SizedBox(height: 50,),
                        buildPassword(),
                        SizedBox(height: 50,),
                        buildConfirmPassword(),
                        SizedBox(height: 50,),
                        buildphone(),
                        SizedBox(height: 50,),
                        buildSignupButton(),
                        SizedBox(height: 30,),

                        Text("الشروط والاحكام", style: TextStyle(color: Colors
                            .white, fontSize: 10),)

                      ],
                    ),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }


  Widget buildSignupButton() {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 25),
      child: Container(
        width: double.infinity,
        child: RaisedButton(
          onPressed: () {
            Navigator.of(context).push(MaterialPageRoute(
                builder: (context) => LoginScreen(),
            ));
          },
          elevation: 5,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(15),
          ),
          color: Color(0xff3c6970),
          padding: EdgeInsets.all(30),
          child: Text("Sign Up", style: TextStyle(fontSize: 10,
              color: Colors.white,
              fontWeight: FontWeight.bold),),
        ),
      ),
    );
  }

  Widget buildphone() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "Phone Number",
          style: TextStyle(
              color: Colors.white, fontSize: 16, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10,),
        Container(
          height: 60,
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(

              color: Color(0xffebefff),
              borderRadius: BorderRadius.circular(10),
              boxShadow: [BoxShadow(
                color: Colors.black26,
                offset: Offset(0, 2),
              )
              ]
          ),
          child: TextField(
            keyboardType: TextInputType.text,
            onSubmitted: (String phone){
              setState((){
                phones=phone;
              });
            },
            style: TextStyle(color: Colors.black),
            decoration: InputDecoration(
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.add_call, color: Color(0xff4c5166),),
                hintText: 'Phone Number',
                hintStyle: TextStyle(color: Colors.black38)
            ),

          ),
        ),
      ],
    );
  }

  Widget buildlname() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "LastName",
          style: TextStyle(
              color: Colors.white, fontSize: 16, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10,),
        Container(
          height: 60,
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(

              color: Color(0xffebefff),
              borderRadius: BorderRadius.circular(10),
              boxShadow: [BoxShadow(
                color: Colors.black26,
                offset: Offset(0, 2),
              )
              ]
          ),
          child: TextField(
            keyboardType: TextInputType.text,
            onSubmitted: (String firstname){
              setState((){
                fname=firstname;
              });
            },
            style: TextStyle(color: Colors.black),
            decoration: InputDecoration(
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.account_box, color: Color(0xff4c5166),),
                hintText: 'Last Name',
                hintStyle: TextStyle(color: Colors.black38)
            ),

          ),
        ),
      ],
    );
  }


  Widget buildfname() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "FirstName",
          style: TextStyle(
              color: Colors.white, fontSize: 16, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10,),
        Container(
          height: 60,
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(

              color: Color(0xffebefff),
              borderRadius: BorderRadius.circular(10),
              boxShadow: [BoxShadow(
                color: Colors.black26,
                offset: Offset(0, 2),
              )
              ]
          ),
          child: TextField(
            keyboardType: TextInputType.text,
            onSubmitted: (String lastname){
              setState((){
                lname=lastname;
              });
            },
            style: TextStyle(color: Colors.black),
            decoration: InputDecoration(
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.account_box, color: Color(0xff4c5166),),
                hintText: 'First Name',
                hintStyle: TextStyle(color: Colors.black38)
            ),

          ),
        ),
      ],
    );
  }


  Widget buildEmail() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text(
          "Email",
          style: TextStyle(
              color: Colors.white, fontSize: 16, fontWeight: FontWeight.bold),
        ),
        SizedBox(height: 10,),
        Container(
          height: 60,
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(

              color: Color(0xffebefff),
              borderRadius: BorderRadius.circular(10),
              boxShadow: [BoxShadow(
                color: Colors.black26,
                offset: Offset(0, 2),
              )
              ]
          ),
          child: TextField(
            keyboardType: TextInputType.emailAddress,
            onSubmitted: (String email){
              setState((){
                Email=email;
              });
            },
            style: TextStyle(color: Colors.black),
            decoration: InputDecoration(
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.email, color: Color(0xff4c5166),),
                hintText: 'Email',
                hintStyle: TextStyle(color: Colors.black38)
            ),

          ),
        ),
      ],
    );
  }

  Widget buildPassword() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text("Password", style: TextStyle(
            color: Colors.white,
            fontSize: 16,
            fontWeight: FontWeight.bold
        ),),
        SizedBox(height: 10,),
        Container(
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(
            color: Color(0xffebefff),
            borderRadius: BorderRadius.circular(10),
            boxShadow: [
              BoxShadow(
                  color: Colors.black26,
                  blurRadius: 6,
                  offset: Offset(0, 2)
              )
            ],
          ),
          height: 60,
          child: TextField(
            onSubmitted: (String password){
              setState((){
                pass=password;
              });
            },
            obscureText: sec,
            style: TextStyle(
                color: Colors.black
            ),
            decoration: InputDecoration(
                suffixIcon: IconButton(
                  onPressed: () {
                    setState(() {
                      sec = !sec;
                    });
                  },
                  icon: sec ? visableoff : visable,


                ),
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.vpn_key,
                  color: Color(0xff4c5166),
                ),
                hintText: "pwd",
                hintStyle: TextStyle(
                    color: Colors.black38
                )
            ),
          ),
        )
      ],
    );
  }


  Widget buildConfirmPassword() {
    return Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Text("Confirm Password", style: TextStyle(
            color: Colors.white,
            fontSize: 16,
            fontWeight: FontWeight.bold
        ),),
        SizedBox(height: 10,),
        Container(
          alignment: Alignment.centerLeft,
          decoration: BoxDecoration(
            color: Color(0xffebefff),
            borderRadius: BorderRadius.circular(10),
            boxShadow: [
              BoxShadow(
                  color: Colors.black26,
                  blurRadius: 6,
                  offset: Offset(0, 2)
              )
            ],
          ),
          height: 60,
          child: TextField(
            obscureText: sec,
            onSubmitted: (String conpassword){
              setState((){
                cpass=conpassword;
              });
            },
            style: TextStyle(
                color: Colors.black
            ),
            decoration: InputDecoration(
                suffixIcon: IconButton(
                  onPressed: () {
                    setState(() {
                      sec = !sec;
                    });
                  },
                  icon: sec ? visableoff : visable,


                ),
                border: InputBorder.none,
                contentPadding: EdgeInsets.only(top: 14),
                prefixIcon: Icon(Icons.vpn_key,
                  color: Color(0xff4c5166),
                ),
                hintText: "pwd",
                hintStyle: TextStyle(
                    color: Colors.black38
                )
            ),
          ),
        )
      ],
    );
  }
}