<?php
mysql_connect("holland.mathcs.emory.edu", "cs377", "abc123")
or die(mysql_error());

mysql_select_db("spjDB")
or die(mysql_error());


$sname = $_POST['sname'];
$scity = $_POST['scity'];
$pname = $_POST['pname'];
$pcity =$_POST['pcity'];
$jname =$_POST['jname'];
$jcity =$_POST['jcity'];
$title=array('Supplier Name','Supplier city','Part Name','Part city','Project Name','Project City');


$query = "select supplier.sname, supplier.city A, part.pname, part.city B, proj.jname, proj.city C from supplier,part,proj,spj where supplier.snum = spj.snum and part.pnum = spj.pnum and proj.jnum = spj.jnum";

if($sname != null){
$condition = false;
for($i=0;$i<strlen($sname);$i++){
if($sname[$i] == "*"){
$sname[$i] = "%";
$addquery = " and supplier.sname like '$sname'";
$query .=$addquery;
$condition = true;
}
}
if($condition == false){
$addquery = " and supplier.sname = '$sname'";
$query .= $addquery;
}
}

if($scity != null){
$condition = false;
for($i=0;$i<strlen($scity);$i++){
if($scity[$i] == "*"){
$scity[$i] = "%";
$addquery = " and supplier.city like '$scity'";
$query .=$addquery;
$condition = true;
}
}
if($condition == false){
$addquery = " and supplier.city = '$scity'";
$query .= $addquery;
}
}

if($pname != null){
$condition = false;
for($i=0;$i<strlen($pname);$i++){
if($pname[$i] == "*"){
$pname[$i] = "%";
$addquery = " and part.pname like '$pname'";
$query .=$addquery;
$condition = true;
}
}
if($condition == false){
$addquery = " and part.pname = '$pname'";
$query .= $addquery;
}
}

if($pcity != null){
$condition = false;
for($i=0;$i<strlen($pcity);$i++){
if($pcity[$i] == "*"){
$pcity[$i] = "%";
$addquery = " and part.city like '$pcity'";
$query .=$addquery;
$condition = true;
}
}

if($condition == false){
$addquery = " and part.city = '$pcity'";
$query .= $addquery;
}
}

if($jname != null){
$condition = false;
for($i=0;$i<strlen($jname);$i++){
if($jname[$i] == "*"){
$jname[$i] = "%";
$addquery = " and proj.jname like '$jname'";
$query .=$addquery;
$condition = true;
}
}
if($condition == false){
$addquery = " and proj.jname = $jname";
$query .= $addquery;
}
}

if($jcity != null){
$condition = false;
for($i=0;$i<strlen($jcity);$i++){
if($jcity[$i] == "*"){
$jcity[$i] = "%";
$addquery = " and proj.city like '$jcity'";
$query .=$addquery;
$condition = true;
}
}
if($condition == false){
$addquery = " and proj.city = '$jcity'";
$query .= $addquery;
}
}



$result = mysql_query($query)
or die(mysql_error());
  print("<UL>\n");
   print("<TABLE bgcolor=\"lightyellow\" BORDER=\"5\">\n");
   	  
   $printed = false;
   
   while ( $row = mysql_fetch_assoc( $result ) )
   {      
      if ( ! $printed )
      {   
   	 $printed = true;                 # Print header once...
   	  
   	 print("<TR bgcolor=\"lightcyan\">\n");
   	 foreach ($title as $key => $value)
   	 {
   	    print ("<TH>" . $value. "</TH>");             # Print attr. name
   	 }
   	 print ("</TH>\n");
      }   
   	  
   	  
      print("<TR>\n");
      foreach ($row as $key => $value)
      {   
   	 print ("<TD>" . $value . "</TD>");
      }   
      print ("</TR>\n");
   }      
   print("</TABLE>\n");
   print("</UL>\n");
   print("<P>\n");
   	  
   
?>
