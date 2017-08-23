<?php
$host='earth.cs.utep.edu';
$user='cs_jecuellar';
$password='cs4342!cs_jecuellar';
$database='cs_jecuellar';
$connection=mysql_connect($host,$user,$password);
if(!$connection){
	die('Could not connect'.mysql_error());
}
mysql_select_db($database,$connection);

$table = $_POST['table'];

$table2 = $_POST['table2'];

if(isset($table2)){
  $query = '';
  if($table2 == 1){
    $query = "SELECT CustomerName, CustomerAddress FROM Customer_T WHERE CustomerName = 'Home Furnishings'";
  }
  if($table2 == 2){
    $query = "SELECT ProductDescription, ProductFinish, ProductStandardPrice FROM Product_T WHERE ProductStandardPrice > 300";
  }
  if($table2 == 3){
    $query = "SELECT CustomerID, CustomerName, GROUP_CONCAT(CustomerID separator ',') AS \"Order Id's\" FROM Customer_T NATURAL JOIN Order_T GROUP BY CustomerID";
  }
  if($table2 == 4){
    $query = "SELECT DISTINCT CustomerState FROM Customer_T";
  }
  if($table2 == 5){
    $query = "SELECT EmployeeName, GROUP_CONCAT(SkillDescription separator ',') AS \"Skill Description\" FROM Employee_T NATURAL JOIN EmployeeSkills_T NATURAL JOIN Skill_T GROUP BY EmployeeID";
  }
  if($table2 == 6){
    $query = "SELECT ProductDescription, SUM(OrderedQuantity) AS \"Total Orders\" FROM Product_T NATURAL JOIN OrderLine_T GROUP BY ProductDescription";
  }

  $result = mysql_query($query);
  $x=mysql_num_rows($result);
  $y=mysql_num_fields($result);
  echo "<h4> degree = ".$y." cardinality = ".$x."</h4>";

  $fieldnm=mysql_field_name($result,0);

  echo "<table border='5' align='center' >";
  echo "<tr>";
  for($i=0; $i<$y; $i++){
  	$fieldnm=mysql_field_name($result,$i);
  	echo "<th>".$fieldnm."</th>";
  }
  echo "</tr>";
  while($rowdata=mysql_fetch_array($result, MYSQL_NUM)){
    echo "<tr>";
    foreach($rowdata as $key => $value){
      echo "<td>".$value."</td>";
    }
    echo "</tr>";
  }
  echo "</table>";
  echo "<h4>closing</h4>";
}

if(isset($table)){
  $query='SELECT * FROM ' . $table;
  $result = mysql_query($query);
  $x=mysql_num_rows($result);
  $y=mysql_num_fields($result);
  echo "<h4> degree = ".$y." cardinality = ".$x."</h4>";

  $fieldnm=mysql_field_name($result,0);

  echo "<table border='5' align='center' >";
  echo "<tr>";
  for($i=0; $i<$y; $i++){
  	$fieldnm=mysql_field_name($result,$i);
  	echo "<th>".$fieldnm."</th>";
  }
  echo "</tr>";
  while($rowdata=mysql_fetch_array($result, MYSQL_NUM)){
    echo "<tr>";
    foreach($rowdata as $key => $value){
      echo "<td>".$value."</td>";
    }
    echo "</tr>";
  }
  echo "</table>";
  echo "<h4>closing</h4>";

}

?>



<form method="post">
<select name="table">
  <?php
    $tables = 'show tables;';
    $result = mysql_query($tables);
    while($row = mysql_fetch_array($result, MYSQL_NUM)){
      $name = $row[0];
      echo "<option value=\"{$name}\">{$name}</option>";
    }
  ?>
<input type="submit" value-"Send"/>
</form>

<form method="post">
<select name="table2">
  <?php
  $question1 = 'What is the address of the customer named Home Furnishings?';
  $question2 = 'What is the product name, finish and standard price for all desks and tables that cost more than 300?';
  $question3 = 'What is the the order id, customer name and customer id of all customers that have placed an order?';
  $question4 = 'What states are PVFC customers from?';
  $question5 = 'What are the names of PVFC employees and their skills?';
  $question6 = 'What is the product description and total order for each product type?';
      echo "<option value=\"1\">{$question1}</option>";
      echo "<option value=\"2\">{$question2}</option>";
      echo "<option value=\"3\">{$question3}</option>";
      echo "<option value=\"4\">{$question4}</option>";
      echo "<option value=\"5\">{$question5}</option>";
      echo "<option value=\"5\">{$question6}</option>";

  ?>
<input type="submit" value-"Send"/>
</form>

<?php
/* What is the address of the customer named Home Furnishings?
$query = SELECT CustomerName, CustomerAddress FROM Customer_T WHERE CustomerName = 'Home Furnishings';

## What is the product name, finish and standard price for all desks and tables that cost more than 300?
$query = SELECT ProductDescription, ProductFinish, ProductStandardPrice FROM Product_T WHERE ProductStandardPrice > 300;

## What is the the order id, customer name and customer id of all customers that have placed an order?
$query = SELECT CustomerID, CustomerName, GROUP_CONCAT(CustomerID separator ',') AS "Order Id's"  FROM Customer_T
          NATURAL JOIN Order_T GROUP BY CustomerID;

## What states are PVFC customers from?
$query = SELECT DISTINCT CustomerState FROM Customer_T;

## What are the names of PVFC employees and their skills?
$query = SELECT EmployeeName, GROUP_CONCAT(SkillDescription separator ',') AS "Skill Description"
          FROM Employee_T NATURAL JOIN EmployeeSkills_T NATURAL JOIN Skill_T GROUP BY EmployeeID;

## What is the product description and total order for each product type?
$query = SELECT ProductDescription, SUM(OrderedQuantity) AS "Total Orders" FROM Product_T NATURAL JOIN OrderLine_T
          GROUP BY ProductDescription;*/
?>
