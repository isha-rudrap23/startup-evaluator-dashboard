function evaluateStartup(){

console.log("Button clicked");

let idea = {

ideaName: document.getElementById("ideaName").value,
marketSize: parseInt(document.getElementById("marketSize").value),
competition: parseInt(document.getElementById("competition").value),
cost: parseInt(document.getElementById("cost").value),
scalability: parseInt(document.getElementById("scalability").value),
innovation: parseInt(document.getElementById("innovation").value)

};

console.log(idea);

fetch("/startup/evaluate",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body: JSON.stringify(idea)
})
.then(response => response.json())
.then(data => {

console.log("Response received:",data);

document.getElementById("resultBox").style.display="block";

document.getElementById("score").innerText =
"Startup Score: "+data.score;

document.getElementById("feedback").innerText =
data.feedback;

let percentage = data.score * 10;

let bar = document.getElementById("scoreBar");

bar.style.width = percentage + "%";
bar.innerText = percentage + "%";



let ratingText = "";

if(data.score >= 8)
ratingText = "🔥 Excellent Startup Idea";

else if(data.score >= 6)
ratingText = "👍 Good Potential";

else if(data.score >= 4)
ratingText = "⚠ Needs Improvement";

else
ratingText = "❌ Weak Idea";

document.getElementById("rating").innerText = ratingText;

});

}