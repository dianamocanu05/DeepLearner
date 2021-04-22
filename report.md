# Deep learner

Project by Mocanu Diana for Advanced Programming 2020-2021 @ FII UAIC

## 1. Problem description

- *Outline:*	
  	1. Neuronal networks
   	2. Using (or creating) a dataset : https://www.kaggle.com/datasets
   	3. Creating a neuronal network for predicting, based on the chosen dataset, using **DeepLearning 4J**
   	4. Creating a GUI for desktop

## 2. Ideas:

**Idea 1** : Making a web site for the application (consisting of two pages: 

		1. interact with the predictor by giving input 
		2. visualizing statistics regarding the dataset and the prediction process)



**Idea 2** Using *Jupyter Notebook* (Java 9 kernel) 

**Idea 3** Using *Apache Zeppelin*

**Idea 3** Datasets to be taken into consideration:

			 -  *Students Performance in Exams* : https://www.kaggle.com/spscientist/students-performance-in-exams

   - *Instrument recognizer* : https://www.classicalarchives.com/midi.html
   - *Music composer* (see above)

**Idea 4** (final) :

	**Dataset** : https://www.kaggle.com/c/fake-news/overview

	**Overview** : Using DeepLearning 4J' s NLP tools for classifying and predicting fake news.

## 3. Structure:

#### 3.1 Import data from csv

#### 3.2 Prepare data for nn pipeline

#### 3.3 Neuronal Network Architecture

```python
    Dropout(0.8),
    LSTM(256),
    Dropout(0.8),
    Dense(256, activation = 'relu'),
    Dropout(0.8),
    Dense(128, activation = 'relu'),
    Dropout(0.8),
    Dense(1,activation = 'sigmoid')]
```

#### 3.4 Create statistics

#### 3.5 Predict with user input data

#### 3.6 GUI/Web

