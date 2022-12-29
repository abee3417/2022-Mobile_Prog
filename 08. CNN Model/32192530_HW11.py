import tensorflow as tf
from tensorflow import keras
import matplotlib.pyplot as plt
from keras import datasets, layers, models

# 과적합 방지 dropout, maxnorm
from keras.layers import Dropout
from keras.constraints import maxnorm

(train_images, train_labels), (test_images, test_labels) = datasets.cifar10.load_data()
train_images=train_images/255.0
test_images=test_images/255.0

model = models.Sequential()
model.add(layers.Conv2D(32, (3,3), activation='relu', input_shape=(32,32,3), padding='same'))
model.add(Dropout(0.2))
model.add(layers.Conv2D(32, (3, 3), activation='relu', padding='same'))
model.add(layers.MaxPooling2D((2,2)))

model.add(layers.Conv2D(64, (3,3), activation='relu', padding='same'))
model.add(Dropout(0.2))
model.add(layers.MaxPooling2D(2,2))
model.add(layers.Conv2D(64, (3,3), activation='relu', padding='same'))

model.add(layers.Conv2D(128, (3,3), activation='relu', padding='same'))
model.add(Dropout(0.2))
model.add(layers.Conv2D(128, (3,3), activation='relu', padding='same'))
model.add(layers.MaxPooling2D((2,2)))

model.add(layers.Flatten())
model.add(Dropout(0.3))

model.add(layers.Dense(512, activation='relu', kernel_constraint=maxnorm(3)))
model.add(Dropout(0.3))
model.add(layers.Dense(256, activation='relu', kernel_constraint=maxnorm(3)))
model.add(Dropout(0.3))
model.add(layers.Dense(128, activation='relu', kernel_constraint=maxnorm(3)))
model.add(Dropout(0.3))
model.add(layers.Dense(10, activation='softmax'))
model.summary() # 테스트 위한 써머리

train_labels = tf.keras.utils.to_categorical(train_labels, 10)
test_labels = tf.keras.utils.to_categorical(test_labels, 10)

model.compile(optimizer='adam', loss=tf.keras.losses.CategoricalCrossentropy(from_logits=True), metrics=['accuracy'])
history=model.fit(train_images, train_labels, epochs=100, batch_size= 100, validation_data=(test_images, test_labels))

plt.plot(history.history['accuracy'], label='accuracy')
plt.plot(history.history['val_accuracy'], label = 'val_accuracy')
plt.xlabel('Epoch')
plt.ylabel('Accuracy')
plt.ylim([0.5, 1])
plt.legend(loc='lower right')
plt.show()

test_loss, test_acc = model.evaluate(test_images, test_labels, verbose=2)
print(test_acc)