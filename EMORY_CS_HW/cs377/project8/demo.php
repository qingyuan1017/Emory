<?
mysql_connect("holland.mathcs.emory.edu", "cs377", "abc123")
or die(mysql_error());

mysql_select_db("spjDB")
or die(mysql_error());

$sname ="'Lofton'";
$scity ="'Athens'";
$pname = null;
$pcity = null;
$jname = null;
$jcity = null;


$query = "select supplier.sname, supplier.city, part.pname, part.city, proj.jname, proj.city from supplier,part,proj,spj where supplier.snum = spj.snum and part.pnum = spj.pnum and proj.jnum = proj.jnum";

if($sname != null){
$addquery = " and supplier.sname = $sname";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}

if($scity != null){
$addquery = " and supplier.city = $scity";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}

if($pname != null){
$addquery = " and part.pname = $pname";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}

if($pcity != null){
$addquery = " and part.city = $pcity";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}

if($jname != null){
$addquery = " and proj.jname = $jname";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}

if($jcity != null){
$addquery = " and proj.city = $jcity";
print($addquery);
print($query);
$query .= $addquery;
print($query);
}



$result = mysql_query($query)
or die(mysql_error());

$printed = false;

while ($row = mysql_fetch_assoc( $result ))
{
   if ( ! $printed )
   {
      $printed = true;                 // Print once...

      foreach ($row as $key => $value)
      {
         print $key . " ";             // Print attr. name
      }
      print "\n---------------------------------\n";
   }

   foreach ($row as $key => $value)
   {
      print $value . " ";
   }
   print "\n";
}
?>
