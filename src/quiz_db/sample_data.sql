USE quizdb;

-- Catégories
INSERT INTO categories (name) VALUES
('Programmation'),
('Mathématiques'),
('Culture Générale');

-- Questions Programmation
INSERT INTO questions (category_id, question_text, option1, option2, option3, option4, correct_option)
VALUES
(1, 'Quel langage est utilisé pour Android ?', 'Java', 'PHP', 'HTML', 'C#', 1),
(1, 'Que signifie OOP ?', 'Object Oriented Programming', 'Open Optical Program', 'Office Operation Process', 'Optional Output Protocol', 1);

-- Questions Mathématiques
INSERT INTO questions (category_id, question_text, option1, option2, option3, option4, correct_option)
VALUES
(2, 'Résultat de 12 × 8 ?', '96', '108', '88', '112', 1),
(2, 'Résultat de 25 % de 200 ?', '25', '100', '50', '75', 3);

-- Questions Culture Générale
INSERT INTO questions (category_id, question_text, option1, option2, option3, option4, correct_option)
VALUES
(3, 'Capitale de la France ?', 'Madrid', 'Rome', 'Paris', 'Berlin', 3),
(3, 'Créateur de Microsoft ?', 'Mark Zuckerberg', 'Bill Gates', 'Elon Musk', 'Steve Jobs', 2);

-- Users de test
INSERT INTO users (username) VALUES ('emna'), ('testuser');
