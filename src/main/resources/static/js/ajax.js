function shuffleCard() {
        $.ajax({
                url: "/cardGame/api/shuffleCard",
                type: "GET",
                dataType: "json",
                success: function(response){
                        // Clear existing table content
                        $("#shuffledCardTable tbody").empty();

                        // Iterate over each row in the response
                        $.each(response, function(index, row){
                                var tr = $("<tr>");
                                // Iterate over each card in the row
                                $.each(row, function(i, card){
                                        tr.append("<td style='border: 1px solid black;'>" + card + "</td>");
                                });
                                // Append row to table body
                                $("#shuffledCardTable tbody").append(tr);
                        });
                },
                error: function(xhr, status, error) {
                        console.error("Error occurred in shuffleCard(): " + error);
                }
        });
}

function distributeCard(data) {
        $.ajax({
                url: "/cardGame/api/distributeCard",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(response){
                        // Clear existing table content
                        $("#playerCardTable tbody").empty();

                        // Iterate over each row in the response
                        $.each(response, function(index, row){
                                var tr = $("<tr>");

                                tr.append("<td style='border: 1px solid black;'>Player " + (index + 1) + ": </td>");
                                // Iterate over each card in the row
                                $.each(row, function(i, card){
                                        tr.append("<td style='border: 1px solid black;'>" + card + "</td>");
                                });
                                // Append row to table body
                                $("#playerCardTable tbody").append(tr);
                        });
                },
                error: function(xhr, status, error) {
                        console.error("Error occurred in distributeCard(): " + error);
                }
        });
}

function findWinner(data) {
        $.ajax({
                url: "/cardGame/api/findWinner",
                type: "POST",
                contentType: "application/json",
                data: JSON.stringify(data),
                success: function(response){
                        $("#winner").text(response);
                },
                error: function(xhr, status, error) {
                        console.error("Error occurred in findWinner(): " + error);
                }
        });
}