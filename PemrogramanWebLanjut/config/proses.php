<?php 
	class proses{
		function __construct(){
			$server='localhost:3308';
			$user='root';
			$psw='';
			$dbname='weblanjut_billa';
			$kon=$this->con=new PDO("mysql:host=$server;dbname=$dbname",$user,$psw);
		}
		function query($query){
			$ret=$this->con->query($query);
			return $ret;
		}
		function get($cel=null,$table=null,$property=null){
			$qw="SELECT $cel FROM $table $property";
			
			$ret=$this->con->query($qw);
			return $ret;
		}
		function insert($table=null,$field=null,$value=null){
			$qw="INSERT INTO $table ($field) VALUES ($value)";
			var_dump($qw);
			$ret=$this->con->query($qw);
			return $qw;
		}
		function update($table=null,$value=null,$property=null){
			$qw="UPDATE $table SET $value WHERE $property";
			$ret=$this->con->query($qw);
			return $ret;
		}
		function delete($table=null,$property=null){
			$qw = "DELETE FROM $table WHERE $property";
			$ret = $this->con->query($qw);
			return $ret;
	}
	}
	$db=new proses;
 ?>