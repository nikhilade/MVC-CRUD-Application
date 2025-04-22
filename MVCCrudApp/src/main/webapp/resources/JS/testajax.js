let search = (str) => {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
        	let data = JSON.parse(this.responseText);
			let str="";
			data.map((e)=>{
				str=str+"<tr>";
				str=str+"<td>"+e.name+"</td>";
				str=str+"<td>"+e.email+"</td>";
				str=str+"<td>"+e.contact+"</td>";
				str=str+"<td><a href=''>DELETE</td>";
				str=str+"<td><a href=''>UPDATE</td>";
				str=str+"</tr>";
			});
			document.getElementById("tbl").innerHTML=str;   
		}
    };

    xhttp.open("GET", "search?v=" + encodeURIComponent(str), true);
    xhttp.send();
}