<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section id="survey">
<c:url var="formAction" value="/surveyInput"/>
<form:form method="POST" action="${formAction}" modelAttribute="surveyInput"> 
<br>
<br>
<label for="Favorite National Park">Favorite National Park</label><span style=color:red>*</span>
<select name="parkCode">
  <option value=""></option>
  <option value="CVNP">Cuyahoga Valley National Park</option>
  <option value="ENP">Everglades National Park</option>
  <option value="GNP">Glacier National Park</option>
  <option value="GCNP">Grand Canyon National Park</option>
  <option value="GTNP">Grand Teton National Park</option>
  <option value="GSMNP">Great Smoky Mountains National Park</option>
  <option value="MRNP">Mount Rainier National Park</option>
  <option value="RMNP">Rocky Mountain National Park</option>
  <option value="YNP">Yellowstone National Park</option>
  <option value="YNP2">Yosemite National Park</option>
</select>
<form:errors path="parkCode"/> 
<br>
<br>

<label for="emailAddress">Your Email</label><span style=color:red>*</span>
 <form:input path="emailAddress" type="text" />
<form:errors path="emailAddress"/> 
<br>
<br>
<label for="State of Residence">State of Residence</label><span style=color:red>*</span>
<select name="stateOfResidence">
  <option value=""></option>
  <option value="AL">Alabama</option>
  <option value="AK">Alaska</option>
  <option value="AZ">Arizona</option>
  <option value="AR">Arkansas</option>
  <option value="CA">California</option>
  <option value="CO">Colorado</option>
  <option value="CT">Connecticut</option>
  <option value="DE">Delaware</option>
  <option value="DC">District Of Columbia</option>
  <option value="FL">Florida</option>
  <option value="GA">Georgia</option>
  <option value="HI">Hawaii</option>
  <option value="ID">Idaho</option>
  <option value="IL">Illinois</option>
  <option value="IN">Indiana</option>
  <option value="IA">Iowa</option>
  <option value="KS">Kansas</option>
  <option value="KY">Kentucky</option>
  <option value="LA">Louisiana</option>
  <option value="ME">Maine</option>
  <option value="MD">Maryland</option>
  <option value="MA">Massachusetts</option>
  <option value="MI">Michigan</option>
  <option value="MN">Minnesota</option>
  <option value="MS">Mississippi</option>
  <option value="MO">Missouri</option>
  <option value="MT">Montana</option>
  <option value="NE">Nebraska</option>
  <option value="NV">Nevada</option>
  <option value="NH">New Hampshire</option>
  <option value="NJ">New Jersey</option>
  <option value="NM">New Mexico</option>
  <option value="NY">New York</option>
  <option value="NC">North Carolina</option>
  <option value="ND">North Dakota</option>
  <option value="OH">Ohio</option>
  <option value="OK">Oklahoma</option>
  <option value="OR">Oregon</option>
  <option value="PA">Pennsylvania</option>
  <option value="RI">Rhode Island</option>
  <option value="SC">South Carolina</option>
  <option value="SD">South Dakota</option>
  <option value="TN">Tennessee</option>
  <option value="TX">Texas</option>
  <option value="UT">Utah</option>
  <option value="VT">Vermont</option>
  <option value="VA">Virginia</option>
  <option value="WA">Washington</option>
  <option value="WV">West Virginia</option>
  <option value="WI">Wisconsin</option>
  <option value="WY">Wyoming</option>
</select>
<form:errors path="stateOfResidence"/> 
<br>
<br>
<label for="Activity Level">Activity Level</label><span style=color:red>*</span>
<input type="radio" name="activity" value="inactive" checked="true">Inactive
<input type="radio" name="activity" value="sedentary">Sedentary
<input type="radio" name="activity" value="active">Active
<input type="radio" name="activity" value="extremelyactive">Extremely Active

<br>

<br>
<button type="submit" value="submit">Submit</button>


</form:form>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />