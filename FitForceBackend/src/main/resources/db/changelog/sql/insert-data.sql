-- Przykładowe dane dla tabeli users
INSERT INTO users (username, password, email, role, first_name, last_name, phone_number, address, city, postal_code, country, instagram, trainings, circuits, weight)
VALUES
  ('john_doe', 'password123', 'john@example.com', 'user', 'John', 'Doe', '+1234567890', '123 Main St', 'Anytown', '12345', 'USA', 'john_doe_insta', 'CrossFit', 'Cardio', '180 lbs'),
  ('jane_smith', 'password456', 'jane@example.com', 'user', 'Jane', 'Smith', '+0987654321', '456 Elm St', 'Othertown', '54321', 'USA', 'jane_smith_insta', 'Weightlifting', 'HIIT', '150 lbs');

-- Przykładowe dane dla tabeli trainings
INSERT INTO trainings (name, description, type, level, duration, equipment, exercises, image_url, trainer, category, calories, comments, date, time, location, price, status, participants, max_participants, rating, reviews, trainer_id, quality, progress)
VALUES
  ('CrossFit Workout', 'Intense full-body workout focusing on strength and conditioning', 'Strength', 'Intermediate', '60 mins', 'Barbell, kettlebell, bodyweight', 'Squats, deadlifts, pull-ups', 'crossfit.jpg', 'John Doe', 'CrossFit', '500', 'Bring water and towel', '2024-04-16', '18:00', 'Gym A', '20.00', 'Open', '10', '20', '4.5', 'Great class!', '1', 'High', '70%'),
  ('HIIT Cardio Session', 'High-intensity interval training for cardiovascular health', 'Cardio', 'Advanced', '45 mins', 'None', 'Running, jumping jacks, burpees', 'hiit.jpg', 'Jane Smith', 'HIIT', '600', 'Wear comfortable shoes', '2024-04-18', '17:30', 'Park B', 'Free', 'Open', '15', '25', '4.0', 'Fun and challenging', '2', 'Medium', '60%');

-- Przykładowe dane dla tabeli circuits

-- Przykładowe dane dla tabeli training_goals
INSERT INTO training_goals (training_id, weight_loss_goal, muscle_gain_goal, increase_speed_goal, increase_acceleration_goal)
VALUES
  (1, 5.0, 2.0, NULL, 10.0),
  (2, NULL, 3.0, 2.0, 5.0);
