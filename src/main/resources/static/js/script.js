(function () {
  const url = window.location.href;

  if (url.includes("?employee-added=true"))
    toast("Employee added successfully", "bg-success");
  else if (url.includes("?employee-updated=true"))
    toast("Employee details updated successfully.", "bg-success");
  else if (url.includes("?employee-deleted=true"))
    toast("Employee deleted", "bg-danger");

  function toast(message, borderColor) {
    const options = {
      animation: true,
      autohide: true,
      delay: 5000,
    };
    const toast = document.getElementById("toast");

    toast.classList.remove("d-none");
    toast.classList.add(borderColor);
    const toast_body = toast.getElementsByClassName("toast-body")[0];
    toast_body.innerHTML = message;
    const bootstrap_toast = new bootstrap.Toast(toast, options);
    bootstrap_toast.show();
  }
})();