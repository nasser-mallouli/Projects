var number = Number(document.getElementById('number').innerHTML);

function increment()
{
    document.getElementById('number').innerHTML = number + 1;
    number = number + 1;
}

function decrement()
{
    document.getElementById('number').innerHTML = number - 1;
    number = number - 1;

}

function reset()
{
    number = 0;
    document.getElementById('number').innerHTML = 0;

}