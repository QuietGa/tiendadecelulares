# --- Funciones del sistema ---
def obtener_bienvenida():
    return "Bienvenido al sistema de celulares"

def listar_clientes():
    return ["Ana", "Luis", "Carlos"]

def calcular_total_ventas(ventas):
    return sum(ventas)

def verificar_stock(producto, stock):
    return stock.get(producto, 0) > 0

# --- Tests ---
def run_tests():
    assert obtener_bienvenida() == "Bienvenido al sistema de celulares"
    assert "Luis" in listar_clientes()
    assert calcular_total_ventas([100, 200, 300]) == 600
    assert verificar_stock("iPhone", {"iPhone": 5}) == True
    assert verificar_stock("Nokia", {"iPhone": 5}) == False
    print("✅ Todos los tests pasaron.")

# --- Ejecutar ---
if __name__ == "__main__":
    run_tests()
