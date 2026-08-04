# Python Streamlit E-Commerce Dashboard

This project creates a simple customer shopping dashboard using Python and Streamlit. It includes:

* Product selection
* Add to cart
* Cart summary
* Checkout form
* Credit/debit card information form
* Order processing simulation

---

## 1. Install Required Packages

Open Git Bash or terminal and run:

```bash
pip install streamlit pandas
```

---

## 2. Create the Python File

Create a file named:

```bash
app.py
```

Paste the following code into `app.py`.

```python
import streamlit as st
import pandas as pd
from datetime import datetime

# -----------------------------
# PAGE CONFIG
# -----------------------------
st.set_page_config(page_title="E-Commerce Dashboard", layout="wide")

st.title("🛒 Customer Shopping Dashboard")
st.write("Select products, add items to cart, and complete checkout.")

# -----------------------------
# SAMPLE PRODUCTS
# -----------------------------
products = [
    {"Product": "Laptop", "Price": 1200},
    {"Product": "Headphones", "Price": 150},
    {"Product": "Keyboard", "Price": 80},
    {"Product": "Mouse", "Price": 40},
    {"Product": "Monitor", "Price": 350},
]

products_df = pd.DataFrame(products)

# -----------------------------
# SESSION STATE
# -----------------------------
if "cart" not in st.session_state:
    st.session_state.cart = []

# -----------------------------
# PRODUCT SECTION
# -----------------------------
st.header("📦 Products")

col1, col2 = st.columns([2, 1])

with col1:
    st.dataframe(products_df, use_container_width=True)

with col2:
    selected_product = st.selectbox(
        "Select Product",
        products_df["Product"]
    )

    quantity = st.number_input(
        "Quantity",
        min_value=1,
        value=1,
        step=1
    )

    if st.button("Add to Cart"):
        product_info = products_df[
            products_df["Product"] == selected_product
        ].iloc[0]

        cart_item = {
            "Product": selected_product,
            "Quantity": quantity,
            "Price": product_info["Price"],
            "Total": quantity * product_info["Price"]
        }

        st.session_state.cart.append(cart_item)
        st.success(f"{selected_product} added to cart.")

# -----------------------------
# CART SECTION
# -----------------------------
st.header("🛍️ Shopping Cart")

if st.session_state.cart:
    cart_df = pd.DataFrame(st.session_state.cart)
    st.dataframe(cart_df, use_container_width=True)

    grand_total = cart_df["Total"].sum()

    st.subheader(f"Grand Total: ${grand_total:.2f}")
else:
    st.info("Your cart is empty.")

# -----------------------------
# CHECKOUT SECTION
# -----------------------------
st.header("💳 Checkout")

with st.form("checkout_form"):
    customer_name = st.text_input("Full Name")
    email = st.text_input("Email")
    address = st.text_area("Shipping Address")

    st.subheader("Payment Information")

    card_name = st.text_input("Name on Card")
    card_number = st.text_input("Card Number", type="password")
    expiry = st.text_input("Expiry Date (MM/YY)")
    cvv = st.text_input("CVV", type="password")

    submitted = st.form_submit_button("Process Order")

# -----------------------------
# ORDER PROCESSING
# -----------------------------
if submitted:
    if not st.session_state.cart:
        st.error("Cart is empty.")

    elif not all([
        customer_name,
        email,
        address,
        card_name,
        card_number,
        expiry,
        cvv
    ]):
        st.error("Please complete all fields.")

    else:
        order_time = datetime.now().strftime("%Y-%m-%d %H:%M:%S")

        st.success("✅ Payment Processed Successfully")

        st.subheader("🧾 Order Summary")

        summary_df = pd.DataFrame(st.session_state.cart)
        st.dataframe(summary_df, use_container_width=True)

        st.write(f"Customer: {customer_name}")
        st.write(f"Email: {email}")
        st.write(f"Order Time: {order_time}")
        st.write(f"Total Amount: ${summary_df['Total'].sum():.2f}")

        st.balloons()

        # Clear cart after processing
        st.session_state.cart = []

```

---

# 3. Run the Application

Open Git Bash or terminal in the project folder and run:

```bash
streamlit run app.py
```

---

# 4. Open the Dashboard

Streamlit automatically opens a browser.

Usually at:

```text
http://localhost:8501
```

---

# Features Included

| Feature          | Description                   |
| ---------------- | ----------------------------- |
| Product Catalog  | Displays products and prices  |
| Add to Cart      | Adds selected products        |
| Shopping Cart    | Displays cart items           |
| Checkout Form    | Captures customer information |
| Payment Form     | Captures card information     |
| Order Processing | Simulates successful payment  |
| Order Summary    | Displays final order details  |

---

# Important Security Note

This example is for learning purposes only.

Real applications should NEVER:

* Store raw card numbers
* Store CVV values
* Process payments without encryption

Production systems typically use secure payment gateways such as:

* Stripe
* PayPal
* Square
* Authorize.Net

---

# Future Improvements

You can later add:

* User login/authentication
* Real database integration
* PostgreSQL backend
* Stripe payment API
* Inventory management
* Order tracking
* Admin dashboard
* Sales analytics
* Email notifications
