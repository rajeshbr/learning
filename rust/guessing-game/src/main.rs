use std::io;

fn main() {
    let secret: u32 = rand::random_range(1..=100);

    let mut input = String::new();
    println!("Enter a number:: ");
    let guess: u32;
    loop {
        io::stdin()
            .read_line(&mut input)
            .expect("Failed to read line");

        guess = match input.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                input.clear();
                println!("Please enter a number!");
                continue;
            }
        };
        break;
    }

    println!("Secret is {}", secret);
    println!("You guessed: {}", guess);
}
