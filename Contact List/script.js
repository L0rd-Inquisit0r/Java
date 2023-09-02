function add()
{
    const prompt=["last name","first name","email address","contact number"];
    var cells=[];
    var table = document.getElementById("table");

    var row = table.insertRow(-1);

    for(let i=0;i<prompt.length;i++)
    {
        cells[i]=row.insertCell(i);
        cells[i].innerHTML=window.prompt("Enter "+prompt[i]+":");
    }
    
    var delBtn=document.createElement("button");
    delBtn.setAttribute("onclick","del(this)");
    delBtn.innerHTML="DELETE";
    row.appendChild(delBtn);

    var updBtn=document.createElement("button");
    updBtn.setAttribute("onclick","upd(this)");
    updBtn.innerHTML="UPDATE";
    row.appendChild(updBtn);
}

function del(x)
{
    var index=x.parentNode.rowIndex;
    document.getElementById("table").deleteRow(index);
}

function upd(x)
{
    var index=x.parentNode.rowIndex;
    var cells=document.getElementById("table").rows[index].cells;
    const prompt=["last name","first name","email address","contact number"];
    for(let i=0;i<prompt.length;i++)
    {
        cells[i].innerHTML=window.prompt("Enter new "+prompt[i]+":");
    }
}