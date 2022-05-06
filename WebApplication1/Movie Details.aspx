<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Movie Details.aspx.cs" Inherits="WebApplication1.Movie_Details" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>BMR_Moives</title>
    <link rel="shortcut icon"  href="IMAGE/BMR.jpg">
    <style>
        .images {
            display: flex;
            flex-wrap: wrap;
            margin: 0 50px;
            padding: 30px;
            text-align:right;
        }
        .photo {
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
            text-align:right;
        }
        .storyn {
            max-width: 31.333%;
            padding: 0 10px;
            height: 240px;
            text-align:right;
        }
        .story {
            padding: 0 10px;
            font-family:bold;
            text-align:right;
        }
        .auto-style1 {
            width: 317px;
        }
        </style>
</head>
<body>
    <form id="form1" runat="server">
         <div><!--Title-->
            <h1 style="height: 88px; background-color: #CCCCCC; text-align: center;">BMR_Movies
                 <input type="search" />
                <asp:Button ID="Button1" runat="server" Text="Subscribe For Free" Width="141px" PostBackUrl="~/signup.aspx" />
                <asp:Button ID="Button2" runat="server" Text="Login" Width="157px" PostBackUrl="~/Login.aspx" />
                <asp:Button ID="Button3" runat="server" Text="Home" Width="157px" PostBackUrl="~/Home.aspx" />
                 <a href="userPage.aspx"><img  src="Images/user.jpeg" width="70px" padding="10px"/></a>
            </h1>
    </div>
        <div class="images">
            <div class="photo">
                <img  src="Images/Venom.jpg"/>
            </div>
            <fieldset style="text-align: left; font-size: larger; color: #FF0000;">
                <p>Venom: Let There Be Carnage</p>
                <p>Language • Country:  English  United State Of America</p>
                <p>Category: • Parents must be instructed. Not suitable for children under 13 years old</p>
                <p>Type: Action</p>
                <p>Evaluation: 6.2 From 10</p>
                <p>duration: 01:37:34</p>
                <p>quality: WEB_D.1080p</p>
                <p>translation: thank you omar al-satiati & islam al-giza!wi</p>
            </fieldset>
        </div>
        <br /><br /><br />
         <div class="images">The story:
             <p>Venom 2 • Phenom: Let there be a massacre
that completes the work of the first part, where journalist Eddie Brock tries to adapt to the problem of hosting his body for the entity named Phenom, and in order to face new opponents on his way.</p>
         </div>
            <fieldset style="width: 80%;">
                <p>heroes
                    <fieldset class="images" style="width: 80%;>
                        <p class="photo">Michelle Williams
                            <br />
                            Anne Weying
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <img  src="Images/Anne Weying.jpg"/>
                        </p>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <p class="photo">Tom Hardy
                            <br />
                           Eddie Brock
                            <img  src="Images/Tom Hardy.jpg"/>
                        </p>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <p class="photo">Andy Serkis
                            <br />
                           المخرج
                            <img  src="Images/Andy Serkis.jpg"/>
                        </p>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <p class="photo">Stephen Graham
                            <br />
                            <img  src="Images/Stephen Graham.jpg"/>
                        </p>
                        <br />
                        <p class="photo">Naomie Harris
                            <br />
                           Shriek (rumored)
                            <img  src="Images/Naomie Harris.jpg"/>
                        </p>
                         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <p class="photo">Woody Harrelson
                            <br />
                           Cletus Kasady
                            <img  src="Images/Woody Harrelson.jpg"/>
                        </p>
                    </fieldset>
                </p>
            </fieldset>
        <table border="1" style="width: 1260px" >
            <thead>
                <th>quality</th>
                <th>accuracy</th>
                <th class="auto-style1">volume</th>
                <th>download</th>
            </thead>
            <tbody>
                <tr>
                    <td>WEB-DL</td>
                    <td>Full HD 1080p </td>
                    <td class="auto-style1">1.7GB</td>
                    <td><a href="https://tena.egybest.zone/movie/venom-let-there-be-carnage-2021/?refresh=6"><input type="button" value="Download"/></a>  <input type="button" value="Wacth"/></td>
                </tr>


                 <tr>
                    <td>WEB-DL</td>
                    <td>HD 720p  </td>
                    <td class="auto-style1">891.1MB</td>
                    <td><input type="button" value="Download"/>  <input type="button" value="Wacth"/></td>
                </tr>

                 <tr>
                    <td>WEB-DL</td>
                    <td>SD 480p  </td>
                    <td class="auto-style1">380.9MB</td>
                    <td><input type="button" value="Download"/>  <input type="button" value="Wacth"/></td>
                </tr>


                 <tr>
                    <td>WEB-DL</td>
                    <td>SD 360p  </td>
                    <td class="auto-style1">231.7MB</td>
                    <td><input type="button" value="Download"/>  <input type="button" value="Wacth"/></td>
                </tr>



                 <tr>
                    <td>WEB-DL</td>
                    <td>Low 240p  </td>
                    <td class="auto-style1">140.4MB</td>
                    <td><input type="button" value="Download"/>  <input type="button" value="Wacth"/></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
