import matplotlib.pyplot as plt

# Data
labels = ['Python', 'Java', 'SQL', 'Excel']
sizes = [35, 25, 20, 20]

# Create pie chart
plt.figure()
plt.pie(sizes, labels=labels, autopct='%1.1f%%')
plt.title('Skill Distribution Example')

plt.show()
