/**
 * Created by Павел on 25-Dec-16.
 */
$("#buyTickBut").click(function () {
    $.post("/html/user/buyTicket",$("#ticketBuyForm").serialize(),function (resp) {
        if (resp=="fine") {
            alert("Ticket bought");
            location.reload();
        } else {
            alert("Vrong luggage")
        }
    })
});