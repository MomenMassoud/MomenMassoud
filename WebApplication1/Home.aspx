<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Home.aspx.cs" Inherits="WebApplication1.Home" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>BMR_Moives</title>
    <link rel="shortcut icon"  href="IMAGE/BMR.jpg">
</head>
    <style>
        .images {
            display: flex;
            flex-wrap: wrap;
            margin: 0 50px;
            padding: 30px;
        }
  
        .photo {
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
        }
        .photoname {
            color:red;
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
        }
  
        .photo img {
            width: 100%;
            height: 100%;
        }
    </style>
<body>
    <form id="form1" runat="server">
    <div><!--Page-->
        <div><!--Title-->
            <h1 style="height: 88px; background-color: #CCCCCC; text-align: center;">BMR_Movies
                <input type="search" />
                <asp:Button ID="Button1" runat="server" Text="Subscribe For Free" Width="141px" PostBackUrl="~/signup.aspx" />
                <asp:Button ID="Button2" runat="server" Text="Login" Width="157px" PostBackUrl="~/Login.aspx" />
                <a href="LoginAdmin.aspx"><input type="button" name="login" value="Login Admin" /></a>
                 <a href="userPage.aspx"><img  src="Images/user.jpeg" width="70px" padding="10px"/></a>
                <a href="adminPage.aspx"><img  src="Images/admin.jpeg" width="70px" padding="10px"/></a>
                
            </h1>
    </div>
        <div role="option" style="text-align: center"><!--body-->

            <asp:Label ID="Label1" runat="server" Text="Welcome In BMR_Movies" Font-Bold="True" ForeColor="#0000CC"></asp:Label>

        </div>


        <br /><br />
        <fieldset>
            <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Movies Recent Add</p>
    <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/Venom.jpg"/>
                </a>
        <div class="photoname">Venom:LetThereBeCarnage</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/الشنطة.jpg"/>
                </a>
        <div class="photoname">الشنطة</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/No Time to Die.jpg"/>
                </a>
        <div class="photoname">NoTimetoDie</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/مش أنا.jpg"/>
                </a>
        <div class="photoname">مش أنا</div>
    </div>
        
        </div>
            </fieldset>
        <br /><br />





        <fieldset>
            <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Movies 2021</p>
    <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/Venom.jpg"/>
                </a>
        <div class="photoname">Venom:LetThereBeCarnage</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/الشنطة.jpg"/>
                </a>
        <div class="photoname">الشنطة</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/No Time to Die.jpg"/>
                </a>
        <div class="photoname">NoTimetoDie</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/مش أنا.jpg"/>
                </a>
        <div class="photoname">مش أنا</div>
    </div>
        
        </div>
            </fieldset>
        <br /><br />




        <fieldset>
            <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Movies Recent Add</p>
    <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/Venom.jpg"/>
                </a>
        <div class="photoname">Venom:LetThereBeCarnage</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/الشنطة.jpg"/>
                </a>
        <div class="photoname">الشنطة</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/No Time to Die.jpg"/>
                </a>
        <div class="photoname">NoTimetoDie</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/مش أنا.jpg"/>
                </a>
        <div class="photoname">مش أنا</div>
    </div>
        
        </div>
            </fieldset>
        <br /><br />





        <fieldset>
            <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Movies Recent Add</p>
    <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/Venom.jpg"/>
                </a>
        <div class="photoname">Venom:LetThereBeCarnage</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/الشنطة.jpg"/>
                </a>
        <div class="photoname">الشنطة</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/No Time to Die.jpg"/>
                </a>
        <div class="photoname">NoTimetoDie</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/مش أنا.jpg"/>
                </a>
        <div class="photoname">مش أنا</div>
    </div>
        
        </div>
            </fieldset>

        <br /><br />




        <fieldset>
            <p style="font-size: 22px; font-style: oblique; color: #0000CC; text-align: center;">Movies Recent Add</p>
    <div class="images">

    <div class="photo">
        <a href="Movie Details.aspx">
        <img  src="Images/Red Notice.jpg"/>
            </a>
        <div class="photoname">RedNotice</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/العارف.jpg"/>
                </a>
        <div class="photoname">العارف</div>
            </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/Venom.jpg"/>
                </a>
        <div class="photoname">Venom:LetThereBeCarnage</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/الشنطة.jpg"/>
                </a>
        <div class="photoname">الشنطة</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/No Time to Die.jpg"/>
                </a>
        <div class="photoname">NoTimetoDie</div>
    </div>

        <div class="photo">
            <a href="Movie Details.aspx">
        <img  src="Images/مش أنا.jpg"/>
                </a>
        <div class="photoname">مش أنا</div>
    </div>
        </div>
        </div>
            
            </fieldset>
    </form>
</body>
</html>
