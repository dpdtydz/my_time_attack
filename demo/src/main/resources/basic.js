let targetId;

$('#button').on('click',
    function addProduct(itemDto) {
        $.ajax({
            type: "POST",
            url: '/api/memos',
            contentType: "application/json",
            data: JSON.stringify(itemDto),
            success: function (response) {
                $('#acticle').addClass('active');
                targetId = response.id;
            }
        })
    })