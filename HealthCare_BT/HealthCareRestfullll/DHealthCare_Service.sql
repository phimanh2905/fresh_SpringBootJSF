create database healthcare;
use healthcare;

create table SERVICES(
	ICON VARCHAR(50) NOT NULL,
    NAME VARCHAR(50) PRIMARY KEY,
    DETAIL VARCHAR(200) NOT NULL,
    PATH VARCHAR(50) NOT NULL
);

INSERT INTO SERVICES(ICON,NAME,DETAIL,PATH) VALUES 
	('fa fa-user-md', 'Prescriptions', 'Treating some psychological disorders and some psychological issues may require a combination of both therapy and some medication...', '#'),
	('fa fa-stethoscope','Interventions','If you want to make a difference for one of your friend\'s or family member\'s life now, a professional intervention is the answer!', '#'),
    ('fa fa-home','Family Therapy','With physical activity being a huge part of one\'s health and wellbeing, it can help you lose weight too!','#'),
    ('fa fa-heart','Anxiety Therapy','With no one-fits-it-all diet program existing, we will custom-tailor a dieting program just for you!','#'),
    ('fa fa-umbrella','Depression Therapy','Behind any overweight issue, there\'s a health problem that\'s hiding. We want to diagnose and treat it!','#'),
    ('fa fa-user-plus','Personal Coaching','When it comes to weight loss treatments, children need an extra special attention given to them...','#'),
    ('fa fa-plus-circle','Child Therapy','Just as it goes for juniors, seniors need a special approach when it comes to weight loss solutions.','#'),
    ('fa fa-child','Psychotherapy','Bariatric (or stomach-related) surgeries are the last option for fixing excessive weight issue.','#');