var clicks = 1;

function addOne() {
    clicks += 1;
    document.getElementById("counter").innerHTML = clicks;
  };

  function deleteOne() {
      if(clicks==1){
        document.getElementById("counter").innerHTML = clicks=1;
      }else{
    clicks -= 1;
    document.getElementById("counter").innerHTML = clicks;
      }
  };
